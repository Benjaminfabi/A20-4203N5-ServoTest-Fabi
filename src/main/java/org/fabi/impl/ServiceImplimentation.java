package org.fabi.impl;

import org.fabi.exceptions.*;
import org.fabi.interfaces.Service;
import org.fabi.modele.VDQuestion;
import org.fabi.modele.VDVote;

import java.util.*;

public class ServiceImplimentation implements Service {

    private static Integer questionId = 0;
    private static Integer voteId = 0;
    List<VDQuestion> listeDeQuestion = new ArrayList();
    List<VDVote> listeDeVote = new ArrayList();




    public void ajoutQuestion(VDQuestion question) throws IdNonNullException, QuestionIdentiqueException, QuestionTailleMauvaise, QuestionNullException, ContenuIdentiqueException {
        if (question == null || question.contenu == null)
        {
            throw new QuestionNullException();
        }
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
            if (q.contenu.toLowerCase().equals(question.contenu.toLowerCase()))
            {
                throw new ContenuIdentiqueException();
            }

        }
        question.id = questionId++;


        listeDeQuestion.add(question.id, question);

    }


    public void ajoutVote(VDVote vote) throws VoteNullException, IndiceTailleException, VoteDoubleException, QuestionNonTrouvableException {
        if (vote == null || vote.nomVoteur == null)
        {
            throw new VoteNullException();
        }
        if (vote.indice > 5 || vote.indice < 0)
        {
            throw new IndiceTailleException();
        }
        int i = 0;
        for ( i = 0; i < listeDeQuestion.size(); i++ )
        {
            if (listeDeQuestion.get(i).id == vote.questionId)
            {
                break;
            }
        }
        if (i >= listeDeQuestion.size()){
            throw new QuestionNonTrouvableException();
        }
        VDQuestion question = listeDeQuestion.get(i);
        for (VDVote v : question.getListeDeVote())
        {
            if (v.nomVoteur.toLowerCase().compareTo(vote.nomVoteur.toLowerCase()) == 0)
            {
                throw new VoteDoubleException();
            }
        }
        vote.id = voteId++;
        listeDeQuestion.get(i).getListeDeVote().add(vote);
    }


    public List<VDQuestion> questionsParNombreVotes()
    {
        List<VDQuestion> listeQuestionCopie = listeDeQuestion;
        Collections.sort(listeQuestionCopie);
        return listeQuestionCopie;
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
