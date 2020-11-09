package org.fabi.modele;

import java.util.*;

public class VDQuestion  implements Comparable<VDQuestion>
{
    public Integer id;
    public String contenu;
    public List<VDVote> ListeDeVote;
    public VDQuestion()
    {

    }

    public void setListeDeVote(List<VDVote> listeDeVote) {
        this.ListeDeVote = listeDeVote;
    }


    public List<VDVote> getListeDeVote() {
        return ListeDeVote;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public VDQuestion(String contenu) {
        setContenu(contenu);
        ListeDeVote = new ArrayList();
        setListeDeVote(ListeDeVote);


    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VDQuestion that = (VDQuestion) o;
        return contenu.equals(that.contenu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contenu);
    }

    @Override
    public int compareTo(VDQuestion o) {
         if (this.getListeDeVote().size() == o.getListeDeVote().size())
                {
                    return this.contenu.toLowerCase().compareTo(o.contenu.toLowerCase());
                }
         return -(this.getListeDeVote().size() - o.getListeDeVote().size());// la soustraction montre le contraire de l'ordre croissant,
    }
}
