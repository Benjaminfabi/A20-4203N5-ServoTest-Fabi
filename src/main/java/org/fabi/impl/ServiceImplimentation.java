package org.fabi.impl;

import org.fabi.interfaces.Service;
import org.fabi.modele.VDQuestion;
import org.fabi.modele.VDVote;

import java.util.List;
import java.util.Map;

public class ServiceImplimentation implements Service {



    public void ajoutQuestion(VDQuestion question)
    {

    }


    public void ajoutVote(VDVote vote) {

    }


    public List<VDQuestion> questionsParNombreVotes() {
        return null;
    }

    public Map<Integer, Integer> distributionPour(VDQuestion question) {
        return null;
    }

    public double moyennePour(VDQuestion question) {
        return 0;
    }

    public double ecartTypePour(VDQuestion question) {
        return 0;
    }


    public String nomEtudiant() {
        return null;
    }
}
