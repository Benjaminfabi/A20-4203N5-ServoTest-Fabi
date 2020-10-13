package org.fabi.interfaces;
import org.fabi.modele.VDQuestion;
import org.fabi.modele.VDVote;
import java.util.List;
import java.util.Map;

public interface Service {

    void ajoutQuestion(VDQuestion question);

    void ajoutVote(VDVote vote);

    List<VDQuestion> questionsParNombreVotes();

    Map<Integer, Integer> distributionPour(VDQuestion question);

    double moyennePour(VDQuestion question);

    double ecartTypePour(VDQuestion question);

    String nomEtudiant();
}

