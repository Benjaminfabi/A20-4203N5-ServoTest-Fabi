package org.fabi.impl;

import org.fabi.exceptions.IdNonNullException;
import org.fabi.exceptions.QuestionIdentiqueException;
import org.fabi.exceptions.QuestionTailleMauvaise;
import org.fabi.interfaces.Service;
import org.fabi.modele.VDQuestion;
import org.fabi.modele.VDVote;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceImplimentation implements Service {


    List<VDQuestion> listeDeQuestion = new ArrayList();
    public void ajoutQuestion(VDQuestion question) throws IdNonNullException, QuestionIdentiqueException, QuestionTailleMauvaise {

        if (question.id != null) throw new IdNonNullException(); //si il possède déjà un id
        if (question.contenu.length() < 5 || question.contenu.length() > 255)
        {
            throw new QuestionTailleMauvaise();
        }
        for (VDQuestion q : listeDeQuestion)
        {
            if (q.contenu == question.contenu)
            {
                throw new QuestionIdentiqueException();
            }
        }



        listeDeQuestion.add(question);

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
