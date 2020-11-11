package org.fabi.impl;
import org.fabi.exceptions.*;
import org.fabi.interfaces.Service;
import org.fabi.modele.VDQuestion;
import org.fabi.modele.VDVote;
import java.util.*;
public class ServiceImplimentation implements Service {
    private Integer questionId = 0;
    private Integer voteId = 0;
    List<VDQuestion> listeDeQuestion = new ArrayList(); // Est utilisé dans questionParNombrevotes(VDQuestion)
    //Implementations
    public void ajoutQuestion(VDQuestion question) throws IdNonNullException, QuestionIdentiqueException, QuestionTailleMauvaise, QuestionNullException, ContenuIdentiqueException {
        if (question == null || question.getContenu() == null)
        {
            throw new QuestionNullException();
        }
        if (question.getId() != null) throw new IdNonNullException(); //si il possède déjà un id
        if (question.getContenu().length() < 5 || question.getContenu().length() > 255)
        {
            throw new QuestionTailleMauvaise();
        }
        for (VDQuestion q : listeDeQuestion)
        {
            if (q.getContenu() == question.getContenu())
            {
                throw new QuestionIdentiqueException();
            }
            if (q.getContenu().toLowerCase().equals(question.getContenu().toLowerCase()))
            {
                throw new ContenuIdentiqueException();
            }

        }
        question.setId(questionId);
        questionId++;

        listeDeQuestion.add(question.getId(), question);

    }

    public void ajoutVote(VDVote vote) throws VoteNullException, IndiceTailleException, VoteDoubleException, QuestionNonTrouvableException {
        if (vote == null || vote.getNomVoteur() == null)
        {
            throw new VoteNullException();
        }
        if (vote.getIndice() > 5 || vote.getIndice() < 0)
        {
            throw new IndiceTailleException();
        }
        int i = 0;
        for ( i = 0; i < listeDeQuestion.size(); i++ )
        {
            if (listeDeQuestion.get(i).getId() == vote.getQuestionId())
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
            if (v.getNomVoteur().toLowerCase().compareTo(vote.getNomVoteur().toLowerCase()) == 0)
            {
                throw new VoteDoubleException();
            }
        }
        vote.setId(voteId);
        voteId++;

        listeDeQuestion.get(i).getListeDeVote().add(vote);
    }

    public List<VDQuestion> questionsParNombreVotes()
    {
        List<VDQuestion> listeQuestionCopie = listeDeQuestion;
        Collections.sort(listeQuestionCopie); //compareTo a été @override dans VDQuestion pour que le sort fonctionne bien
        return listeQuestionCopie;
    }
    public Map<Integer, Integer> distributionPour(VDQuestion question) {
        Map<Integer, Integer> distributionMap = new HashMap<Integer, Integer>();
        Integer noteMax = 5;

        Integer[] tab = new Integer[5];
        tab[0] = 0;
        tab[1] = 0;
        tab[2] = 0;
        tab[3] = 0;
        tab[4] = 0;
        for (VDVote v : question.getListeDeVote()) {
            tab[v.getIndice() - 1]++;
        }
        for (int i = 0; i < noteMax; i++) {
            distributionMap.put(i+1, tab[i]);
        }
        return distributionMap;
    }

    public double moyennePour(VDQuestion question) throws QuestionAucunVoteException {
        if (question.getListeDeVote().size() <= 0 )
        {
            throw new QuestionAucunVoteException();
        }
        Map<Integer, Integer> map = distributionPour(question);
        Integer somme =  1 * map.get(1) + 2 * map.get(2) + 3 * map.get(3) + 4 *  map.get(4) + 5 * map.get(5);
        if (somme > 0)
        {
            return ((double) somme / question.getListeDeVote().size());
        }
        return 0;
    }

    public double ecartTypePour(VDQuestion question) throws QuestionAucunVoteException {
        if (question.getListeDeVote().size() <= 0 )
        {
            throw new QuestionAucunVoteException();
        }
        double[] tab = new double[question.getListeDeVote().size()];
        Integer index = 0;
        for (VDVote v : question.getListeDeVote())
        {
            tab[index] = v.getIndice();
            index++;
        }

        return calculET(tab);

    }

    public double calculET(double tab[])
    {
        double somme = 0.0, ecartType = 0.0;
        int taille = tab.length;

        for(double nb : tab) {
            somme += nb;
        }

        double div = somme/taille;

        for(double nb: tab) {
            ecartType += Math.pow(nb - div, 2);
        }

        return Math.sqrt(ecartType/taille);

    }
    public String nomEtudiant() {
        return null;
    }
}
