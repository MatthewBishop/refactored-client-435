package org.runejs.client.audio;

import org.runejs.client.audio.core.Effect;
import org.runejs.client.audio.core.LinkedList;
import org.runejs.client.audio.core.Node;
import org.runejs.client.cache.def.GameObjectDefinition;

public class AreaSounds {
	
	private static LinkedList objectSounds = new LinkedList();

	public static void addObjectSounds(int arg0, int arg2, int arg3, int arg4, GameObjectDefinition def) {
		ObjectSound objectSound = new ObjectSound();
		objectSound.hearDistance = 128 * def.ambientSoundHearDistance;
		objectSound.unkn2 = def.unkn2;
		objectSound.soundEffectIds = def.soundEffectIds;
		objectSound.unkn1 = def.unkn1;
		int size1 = def.sizeX;
		int size2 = def.sizeY;
		objectSound.plane = arg2;
		objectSound.minX = arg4 * 128;
		if (arg3 == 1 || arg3 == 3) {
			size1 = def.sizeY;
			size2 = def.sizeX;
		}
		objectSound.minY = 128 * arg0;
		objectSound.maxY = (size2 + arg0) * 128;
		objectSound.maxX = (arg4 + size1) * 128;
		objectSound.soundEffectId = def.ambientSoundId;
		if (def.childIds != null) {
			objectSound.def = def;
			objectSound.set();
		}
		AreaSounds.objectSounds.pushBack(objectSound);
		if (objectSound.soundEffectIds != null)
			objectSound.anInt2014 = (int) ((objectSound.unkn2 - objectSound.unkn1) * Math.random()) + objectSound.unkn1;
	}

	public static void clearObjectSounds() {
		for (ObjectSound objectSound = (ObjectSound) AreaSounds.objectSounds.first(); objectSound != null; objectSound = (ObjectSound) AreaSounds.objectSounds.next()) {
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

	public static void setObjectSounds() {
		for (ObjectSound objectSound = (ObjectSound) AreaSounds.objectSounds.first(); objectSound != null; objectSound = (ObjectSound) AreaSounds.objectSounds.next()) {
			if (objectSound.def != null) {
				objectSound.set();
			}
		}
	}

	public static void updateObjectSounds(int pwx, int pwl, int redrawRate, int pwy) {
		for (ObjectSound objectSound = (ObjectSound) AreaSounds.objectSounds.first(); objectSound != null; objectSound = (ObjectSound) AreaSounds.objectSounds.next()) {
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
	
	private static class ObjectSound extends Node {

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
		private GameObjectDefinition def;
		private int unkn1;
		private int maxX;
		private int anInt2014;

		private void set() {
			int i = soundEffectId;
			GameObjectDefinition gameObjectDefinition = this.def.getChildDefinition();
			if (gameObjectDefinition == null) {
				hearDistance = 0;
				unkn1 = 0;
				unkn2 = 0;
				soundEffectIds = null;
				soundEffectId = -1;
			} else {
				hearDistance = 128 * gameObjectDefinition.ambientSoundHearDistance;
				unkn1 = gameObjectDefinition.unkn1;
				unkn2 = gameObjectDefinition.unkn2;
				soundEffectId = gameObjectDefinition.ambientSoundId;
				soundEffectIds = gameObjectDefinition.soundEffectIds;
			}
			if (i != soundEffectId && stream1 != null) {
				SoundSystem.removeSubStream(stream1);
				stream1 = null;
			}
		}
	}
}
