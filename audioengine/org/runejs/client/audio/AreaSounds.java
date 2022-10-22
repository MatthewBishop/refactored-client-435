package org.runejs.client.audio;

import org.runejs.client.adapter.IGameObjectDefinition;

public class AreaSounds {
	
	private static _LinkedList objectSounds = new _LinkedList();

	/**
	 * Called when adding a object to a map region. This is called either on spawn, map load, or construct packet
	 * @param localY local Y coordinate of the object on the map
	 * @param plane the object's plane on the map
	 * @param rotation the object's rotation
	 * @param localX local Y coordinate of the object on the map
	 * @param def the object definition for the object.
	 */
	public static void addObjectSounds(int localY, int plane, int rotation, int localX, IGameObjectDefinition def) {
		ObjectSound objectSound = new ObjectSound();
		objectSound.hearDistance = 128 * def.soundRange();
		objectSound.unkn2 = def.soundMax();
		objectSound.soundEffectIds = def.soundIds();
		objectSound.unkn1 = def.soundMin();
		int size1 = def.sizeX();
		int size2 = def.sizeY();
		objectSound.plane = plane;
		objectSound.minX = localX * 128;
		if (rotation == 1 || rotation == 3) {
			size1 = def.sizeY();
			size2 = def.sizeX();
		}
		objectSound.minY = 128 * localY;
		objectSound.maxY = (size2 + localY) * 128;
		objectSound.maxX = (localX + size1) * 128;
		objectSound.soundEffectId = def.soundId();
		if (def.getTransforms() != null) {
			objectSound.def = def;
			objectSound.set();
		}
		AreaSounds.objectSounds.pushBack(objectSound);
		if (objectSound.soundEffectIds != null)
			objectSound.anInt2014 = (int) ((objectSound.unkn2 - objectSound.unkn1) * Math.random()) + objectSound.unkn1;
	}

	/**
	 * Called when logging out and also when loading a new map region.
	 */
	public static void clearObjectSounds() {
		for (ObjectSound objectSound = (ObjectSound) AreaSounds.objectSounds.peek(); objectSound != null; objectSound = (ObjectSound) AreaSounds.objectSounds.next()) {
			if (objectSound.stream1 != null) {
				SoundSystem.removeSubStream(objectSound.stream1);
				objectSound.stream1 = null;
			}
			if (objectSound.stream2 != null) {
				SoundSystem.removeSubStream(objectSound.stream2);
				objectSound.stream2 = null;
			}
		}
		AreaSounds.objectSounds.clear();
	}

	/**
	 * Called whenever the game options are updated. This is when the music/sound effect volume is changed and also brightness. 
	 */
	public static void setObjectSounds() {
		for (ObjectSound objectSound = (ObjectSound) AreaSounds.objectSounds.peek(); objectSound != null; objectSound = (ObjectSound) AreaSounds.objectSounds.next()) {
			if (objectSound.def != null) {
				objectSound.set();
			}
		}
	}

	/**
	 * Called when drawing the game screen.
	 * @param pwx Player world X
	 * @param pwl Player world level
	 * @param redrawRate Whatever value that is passed in when animating a texture like water or firecape.
	 * @param pwy Player world Y
	 */
	public static void updateObjectSounds(int pwx, int pwl, int redrawRate, int pwy) {
		for (ObjectSound objectSound = (ObjectSound) AreaSounds.objectSounds.peek(); objectSound != null; objectSound = (ObjectSound) AreaSounds.objectSounds.next()) {
			if (objectSound.soundEffectId != -1 || objectSound.soundEffectIds != null) {
				int distance = 0;
				if (pwx <= objectSound.maxX) {
					if (pwx < objectSound.minX)
						distance += objectSound.minX - pwx;
				} else
					distance += -objectSound.maxX + pwx;
				if (pwy > objectSound.maxY)
					distance += -objectSound.maxY + pwy;
				else if (pwy < objectSound.minY)
					distance += -pwy + objectSound.minY;
				if (objectSound.hearDistance < -64 + distance || SoundSystem.getAreaSoundEffectVolume() == 0 || pwl != objectSound.plane) {
					if (objectSound.stream1 != null) {
						SoundSystem.removeSubStream(objectSound.stream1);
						objectSound.stream1 = null;
					}
					if (objectSound.stream2 != null) {
						SoundSystem.removeSubStream(objectSound.stream2);
						objectSound.stream2 = null;
					}
				} else {
					distance -= 64;
					if (distance < 0)
						distance = 0;
					int volume = (-distance + objectSound.hearDistance) * SoundSystem.getAreaSoundEffectVolume() / objectSound.hearDistance;
					if (objectSound.stream1 == null) {
						if (objectSound.soundEffectId >= 0) {
							Effect effect = SoundSystem.readSoundEffect(objectSound.soundEffectId);
							if (effect != null) {
								objectSound.stream1 = SoundSystem.addEffect(effect, volume, -1);
							}
						}
					} else
						objectSound.stream1.setVolume(volume);
					if (objectSound.stream2 == null) {
						if (objectSound.soundEffectIds != null && (objectSound.anInt2014 -= redrawRate) <= 0) {
							int i_50_ = (int) (objectSound.soundEffectIds.length * Math.random());
							Effect effect = SoundSystem.readSoundEffect(objectSound.soundEffectIds[i_50_]);
							if (effect != null) {
								objectSound.anInt2014 = objectSound.unkn1 + (int) ((-objectSound.unkn1 + objectSound.unkn2) * Math.random());
								objectSound.stream2 = SoundSystem.addEffect(effect, volume, 0);
							}
						}
					} else {
						objectSound.stream2.setVolume(volume);
						if (!objectSound.stream2.hasNext())
							objectSound.stream2 = null;
					}
				}
			}
		}
	}
	
	private static class ObjectSound extends _Node {

		private int plane;
		private int minX;
		private int soundEffectId;
		private int hearDistance;
		private RawPcmStream stream1;
		private int unkn2;
		private int minY;
		private int[] soundEffectIds;
		private int maxY;
		private RawPcmStream stream2;
		private IGameObjectDefinition def;
		private int unkn1;
		private int maxX;
		private int anInt2014;

		private void set() {
			int i = soundEffectId;
			IGameObjectDefinition gameObjectDefinition = this.def.transform();
			if (gameObjectDefinition == null) {
				hearDistance = 0;
				unkn1 = 0;
				unkn2 = 0;
				soundEffectIds = null;
				soundEffectId = -1;
			} else {
				hearDistance = 128 * gameObjectDefinition.soundRange();
				unkn1 = gameObjectDefinition.soundMin();
				unkn2 = gameObjectDefinition.soundMax();
				soundEffectId = gameObjectDefinition.soundId();
				soundEffectIds = gameObjectDefinition.soundIds();
			}
			if (i != soundEffectId && stream1 != null) {
				SoundSystem.removeSubStream(stream1);
				stream1 = null;
			}
		}
	}
}
