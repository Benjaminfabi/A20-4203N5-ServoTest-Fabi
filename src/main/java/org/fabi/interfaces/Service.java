package org.fabi.interfaces;
import org.fabi.exceptions.IdNonNullException;
import org.fabi.exceptions.QuestionIdentiqueException;
import org.fabi.exceptions.QuestionTailleMauvaise;
import org.fabi.modele.VDQuestion;
import org.fabi.modele.VDVote;
import java.util.List;
import java.util.Map;

public interface Service {

    void ajoutQuestion(VDQuestion question) throws IdNonNullException, QuestionIdentiqueException, QuestionTailleMauvaise;

    void ajoutVote(VDVote vote);

    List<VDQuestion> questionsParNombreVotes(); //parcourir toute les questions et créer une liste de VDQuestion qui on x nombre de vote

    Map<Integer, Integer> distributionPour(VDQuestion question);

    double moyennePour(VDQuestion question);

    double ecartTypePour(VDQuestion question);

    String nomEtudiant();
}

