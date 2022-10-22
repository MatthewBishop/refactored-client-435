package org.runejs.client.adapter;

public interface IGameObjectDefinition {

	int soundMax();
	int soundMin();
	int soundRange();
	int soundId();
	int sizeY();
	int sizeX();
	
	int[] soundIds();
	Object getTransforms();
	IGameObjectDefinition transform();
	
}
