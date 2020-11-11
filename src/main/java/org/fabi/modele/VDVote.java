package org.fabi.modele;

public class VDVote
{
    private Integer id;
    private String nomVoteur;
    private Integer questionId;
    private Integer indice;
    public VDVote()
    {

    }

    public VDVote(Integer questionId, String nomVoteur, Integer indice)
    {
        setIndice(indice);
        setNomVoteur(nomVoteur);
        setQuestionId(questionId);

    }

    public void setId(Integer id) {
        this.id = id;
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



}
