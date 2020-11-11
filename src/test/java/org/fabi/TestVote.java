package org.fabi;


import org.fabi.exceptions.*;
import org.fabi.impl.ServiceImplimentation;
import org.fabi.interfaces.Service;
import org.fabi.modele.VDQuestion;
import org.fabi.modele.VDVote;
import org.junit.Assert;
import org.junit.Test;

public class TestVote
{
    //TESTS POUR VDVOTE
    @Test(expected = VoteNullException.class)
    public void VoteNull() throws VoteNullException, IndiceTailleException, VoteDoubleException, QuestionNonTrouvableException {
        Service service = new ServiceImplimentation();
        service.ajoutVote(null);
    }
    @Test(expected = IndiceTailleException.class)
    public void IndiceTailleTropCourt() throws VoteNullException, IndiceTailleException, VoteDoubleException, QuestionNonTrouvableException {
        Service service = new ServiceImplimentation();
        VDVote vote = new VDVote(3,"allllalo",-1);
        service.ajoutVote(vote);
    }
    @Test(expected = IndiceTailleException.class)
    public void IndiceTailleTropLong() throws VoteNullException, IndiceTailleException, VoteDoubleException, QuestionNonTrouvableException {
        Service service = new ServiceImplimentation();
        service.ajoutVote(new VDVote(3,"allllalo",6));
    }
    @Test(expected = VoteDoubleException.class)
    public void DoubleVote() throws VoteNullException, IndiceTailleException, VoteDoubleException, QuestionNonTrouvableException, ContenuIdentiqueException, IdNonNullException, QuestionTailleMauvaise, QuestionNullException, QuestionIdentiqueException {
        Service service = new ServiceImplimentation();
        VDQuestion question = new VDQuestion("contenu");
        service.ajoutQuestion(question);
        VDVote voteMaude = new VDVote(question.getId(), "Maude",3);
        VDVote votemaude = new VDVote(question.getId(),"maude",3);
        service.ajoutVote(voteMaude);
        service.ajoutVote(votemaude);
    }
    @Test(expected = QuestionNonTrouvableException.class)
    public void QuestionNonTrouvable() throws VoteNullException, IndiceTailleException, VoteDoubleException, QuestionNonTrouvableException, ContenuIdentiqueException, IdNonNullException, QuestionTailleMauvaise, QuestionNullException, QuestionIdentiqueException { //Le vote n'est pas rattaché à une question!
        Service service = new ServiceImplimentation();
        service.ajoutQuestion(new VDQuestion("TESTQUESTION"));
        VDVote vote = new VDVote(2,"maude",3); //QUESITON ID : pour voir si il va trouver la question avec l'id 2
        service.ajoutVote(vote);
    }
    @Test
    public void AjouVoteAQuestion() throws VoteNullException, IndiceTailleException, VoteDoubleException, QuestionNonTrouvableException, ContenuIdentiqueException, IdNonNullException, QuestionTailleMauvaise, QuestionNullException, QuestionIdentiqueException { //Le vote n'est pas rattaché à une question!
        Service service = new ServiceImplimentation();
        VDQuestion question = new VDQuestion("TESTQUESTION");
        service.ajoutQuestion(question);
        VDVote vote = new VDVote(question.getId(), "maude",3);
        service.ajoutVote(vote);
        Assert.assertEquals(1, question.getListeDeVote().size());
    }
}
