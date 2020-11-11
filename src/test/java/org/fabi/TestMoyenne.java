package org.fabi;

import org.fabi.exceptions.*;
import org.fabi.impl.ServiceImplimentation;
import org.fabi.interfaces.Service;
import org.fabi.modele.VDQuestion;
import org.fabi.modele.VDVote;
import org.junit.Assert;
import org.junit.Test;

public class TestMoyenne
{
    @Test
    public void TestMoyenne() throws VoteDoubleException, VoteNullException, IndiceTailleException, QuestionNonTrouvableException, ContenuIdentiqueException, IdNonNullException, QuestionTailleMauvaise, QuestionNullException, QuestionIdentiqueException, QuestionAucunVoteException {
        Service service = new ServiceImplimentation();
        VDQuestion question = new VDQuestion("Quelle est la question?");
        service.ajoutQuestion(question);
        VDVote vote1 = new VDVote(0,"Maurice", 2);
        service.ajoutVote(vote1);
        VDVote vote2 = new VDVote(0,"Pedro", 4);
        service.ajoutVote(vote2);
        VDVote vote3 = new VDVote(0,"Caroline", 4);
        service.ajoutVote(vote3);
        VDVote vote4 = new VDVote(0,"Bastien", 1);
        service.ajoutVote(vote4);
        VDVote vote5 = new VDVote(0,"Chantal", 4);
        service.ajoutVote(vote5);
        VDVote vote6 = new VDVote(0,"Corneille", 2);
        service.ajoutVote(vote6);
        Assert.assertEquals(3, service.moyennePour(question), 1);
    }
    @Test(expected = QuestionAucunVoteException.class)
    public void QuestionAucunVote() throws VoteDoubleException, VoteNullException, IndiceTailleException, QuestionNonTrouvableException, ContenuIdentiqueException, IdNonNullException, QuestionTailleMauvaise, QuestionNullException, QuestionIdentiqueException, QuestionAucunVoteException {
        Service service = new ServiceImplimentation();
        VDQuestion question = new VDQuestion("Quelle est la question?");
        service.ajoutQuestion(question);
        service.moyennePour(question);
    }
}
