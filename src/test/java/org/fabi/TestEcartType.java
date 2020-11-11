package org.fabi;

import org.fabi.exceptions.*;
import org.fabi.impl.ServiceImplimentation;
import org.fabi.interfaces.Service;
import org.fabi.modele.VDQuestion;
import org.fabi.modele.VDVote;
import org.junit.Assert;
import org.junit.Test;

public class TestEcartType
{
    //Assert Equals avec l'exemple de l'énoncé du TP
    @Test
    public void TestEcartType() throws VoteDoubleException, VoteNullException, IndiceTailleException, QuestionNonTrouvableException, ContenuIdentiqueException, IdNonNullException, QuestionTailleMauvaise, QuestionNullException, QuestionIdentiqueException, QuestionAucunVoteException
        {
            Service service = new ServiceImplimentation();
            VDQuestion question = new VDQuestion("Quelle est la question?");
            service.ajoutQuestion(question);
            VDVote vote1 = new VDVote(0, "Maurice", 2);
            service.ajoutVote(vote1);
            VDVote vote2 = new VDVote(0, "Pedro", 2);
            service.ajoutVote(vote2);
            VDVote vote3 = new VDVote(0, "Caroline", 5);
            service.ajoutVote(vote3);
            Assert.assertEquals(1.41, service.ecartTypePour(question), 1);
        }
    //Si la question n'a pas de vote, la fonction de l'écart type ne fonctionnera pas et lèvera une exception attendue
    @Test(expected = QuestionAucunVoteException.class)
    public void QuestionAucunVote() throws VoteDoubleException, VoteNullException, IndiceTailleException, QuestionNonTrouvableException, ContenuIdentiqueException, IdNonNullException, QuestionTailleMauvaise, QuestionNullException, QuestionIdentiqueException, QuestionAucunVoteException {
        Service service = new ServiceImplimentation();
        VDQuestion question = new VDQuestion("Quelle est la question?");
        service.ajoutQuestion(question);
        service.moyennePour(question);
    }
}
