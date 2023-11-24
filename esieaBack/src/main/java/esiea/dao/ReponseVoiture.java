package esiea.dao;

import esiea.metier.Voiture;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReponseVoiture {

	private Voiture[] data;
	private int volume;
	public Voiture[] getData() {
		return data;
	}
	public void setData(Voiture[] data) {
		this.data = data;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public void setData(Voiture v, int index) {
		if(data == null) {
			data = new Voiture[index+1];
		}
		data[index] = v;
	}

	public List<Voiture> getVoitures() {
		if (data != null) {
			return Arrays.asList(data);
		} else {
			return Collections.emptyList();
		}
	}

	// Méthode pour définir une liste de voitures (setVoitures)
	public void setVoitures(List<Voiture> voitures) {
		if (voitures != null) {
			data = voitures.toArray(new Voiture[0]);
		} else {
			data = null;
		}
	}


}
