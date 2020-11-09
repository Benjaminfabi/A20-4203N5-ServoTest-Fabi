package org.fabi;

import org.fabi.exceptions.*;
import org.fabi.impl.ServiceImplimentation;
import org.fabi.interfaces.Service;
import org.fabi.modele.VDQuestion;
import org.fabi.modele.VDVote;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class TestDistribution
{
    @Test
    public void TestDistribution() throws VoteDoubleException, VoteNullException, IndiceTailleException, QuestionNonTrouvableException, ContenuIdentiqueException, IdNonNullException, QuestionTailleMauvaise, QuestionNullException, QuestionIdentiqueException {
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

        Map<Integer, Integer> map = service.distributionPour(question);

        Assert.assertEquals("1 pour 1/5 ; 2 pour 2/5 ; 0 pour 3/5 ; 3 pour 4/5 ; 0 pour 5/5 ; ", map.get(1) + " pour 1/5 ; " + map.get(2) + " pour 2/5 ; " + map.get(3) + " pour 3/5 ; " + map.get(4) + " pour 4/5 ; " + map.get(5) + " pour 5/5 ; ");

    }


}
