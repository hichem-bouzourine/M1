mtype {INDETERMINEE,VERT,ROUGE,ORANGE}

chan obs = [0] of {mtype, bool};



active proctype feu(){
    bool clignotant = false;
    mtype couleur = INDETERMINEE;

    initial:
        couleur = ORANGE;
        clignotant = true;

        if
        :: true -> clignotant = false; goto feu_rouge;
        :: true -> goto initial
        fi
    feu_rouge:
        atomic{
            couleur = ROUGE;
            obs!couleur, clignotant;
        }
        if
        :: true -> goto feu_vert;
        :: true -> goto panne;
        :: true -> goto feu_rouge;
        fi
    feu_vert:
        atomic{
            couleur = VERT;
            obs!couleur, clignotant;
        }
        
        if
        :: true -> goto feu_orange;
        :: true -> goto panne;
        :: true -> goto feu_vert;
        fi
    feu_orange:
        atomic{
            couleur = ORANGE;
            obs!couleur, clignotant;
        }  
        if
        :: true -> goto feu_rouge;
        :: true -> goto feu_orange;
        :: true -> goto panne;
        fi 
    panne:
        clignotant = true;
    panne_boucle:
        couleur = ORANGE;
        obs!couleur, clignotant;
        if
        :: true -> goto panne
        :: true -> goto panne_boucle
        fi   
}

active proctype observer(){
    mtype couleur, feu_ancien;
    bool cli; 
    feu_ancien = INDETERMINEE;


    do
    :: obs?(couleur, cli) -> 
        if
        ::couleur == ORANGE ->atomic{
                assert(cli == true || feu_ancien != ROUGE);
                feu_ancien = ORANGE
            }
        ::couleur == ROUGE -> atomic{
                assert(feu_ancien != VERT);
                feu_ancien = ROUGE
            }
        ::couleur == VERT ->atomic{
                assert(feu_ancien != ORANGE);
                feu_ancien = VERT
            } 
        ::cli -> atomic{assert(couleur == ORANGE)}   
        fi
    od
}