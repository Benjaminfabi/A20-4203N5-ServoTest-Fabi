package org.fabi.modele;

public class VDVote
{
    public Integer id;
    public String nomVoteur;
    public Integer questionId;
    public Integer indice;
    public VDVote()
    {

    }



    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
    public Integer getQuestionId() {
        return questionId;
    }
    public String getNomVoteur() {
        return nomVoteur;
    }
    public void setNomVoteur(String nomVoteur) {
        this.nomVoteur = nomVoteur;
    }
    public Integer getIndice() {
        return indice;
    }
    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public VDVote(Integer questionId, String nomVoteur, Integer indice)
    {
        setIndice(indice);
        setNomVoteur(nomVoteur);
        setQuestionId(questionId);

    }


}
