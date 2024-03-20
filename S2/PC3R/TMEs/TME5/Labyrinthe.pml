active proctype labyrinthe(){
    initial:
        if
            :: true -> printf("Position initiale à (0,4)"); goto adresse_0_4
        fi
    adresse_0_4:
        if
            ::true -> printf("Partir en Haut vers (1,4)"); goto adresse_1_4
        fi
    adresse_1_4:
        if
            ::true -> printf("Aller à Gauche vers (1,3)"); goto adresse_1_3
            ::true -> printf("Aller en Haut vers (2,4)"); goto adresse_2_4
            ::true -> printf("Aller en Bas vers (0,4)"); goto adresse_0_4
        fi
    adresse_2_4:
        if
            ::true -> printf("Aller en Haut vers (3,4)"); goto adresse_3_4
            ::true -> printf("Aller en Bas vers (1,4)"); goto adresse_1_4
        fi
    adresse_3_4:
        if
            ::true -> printf("Aller en Haut vers (4,4)"); goto adresse_4_4
            ::true -> printf("Aller en Bas vers (2,4)"); goto adresse_2_4
        fi
    adresse_4_4:
        if
            ::true -> printf("Aller en Bas vers (3,4)"); goto adresse_3_4
        fi
    adresse_1_3:
        if
            ::true -> printf("Aller à Gauche vers (1,2)"); goto adresse_1_2
            ::true -> printf("Aller à Droite vers (1,4)"); goto adresse_1_4
        fi
    adresse_1_2:
        if
            ::true -> printf("Aller à Gauche vers (1,1)"); goto adresse_1_1
            ::true -> printf("Aller à Droite vers (1,3)"); goto adresse_1_3
        fi
    adresse_1_1:
        if
            ::true -> printf("Aller en Haut vers (2,1)"); goto adresse_2_1
            ::true -> printf("Aller en Bas vers (0,1)"); goto adresse_0_1
        fi
    adresse_0_1:
        if
            ::true -> printf("Aller en Haut vers (1,1)"); goto adresse_1_1
            ::true -> printf("Aller à Droite vers (0,2)"); goto adresse_0_2
        fi
    adresse_0_2:
        if
            ::true -> printf("Aller à Gauche vers (0,1)"); goto adresse_0_1
            ::true -> printf("Aller à Droite vers (0,3)"); goto adresse_0_3
        fi
    adresse_0_3:
        if
            ::true -> printf("Aller à Gauche vers (0,2)"); goto adresse_0_2
        fi
    adresse_2_1:
        if
            ::true -> printf("Aller Haut vers (3,1)"); goto adresse_3_1
            ::true -> printf("Aller à Gauche vers (2,0)"); goto adresse_2_0
        fi
    adresse_2_0:
        if
            ::true -> printf("Aller à Droite vers (2,1)"); goto adresse_2_1
        fi
    adresse_3_1:
        if
            ::true -> printf("Aller en Haut vers (3,2)"); goto adresse_3_2
        fi
    adresse_3_2:
        if  
            ::true -> printf("Aller à Gauche vers (3,1)"); goto adresse_3_1
            ::true -> printf("Aller à Droite vers (3,3)"); goto adresse_3_3
        fi
    adresse_3_3:
        if
            ::true -> printf("Aller en Haut vers (4,3)"); goto adresse_4_3
            ::true -> printf("Aller à Gauche vers (3,2)"); goto adresse_3_2
        fi
    adresse_4_3:
        if
            ::true -> printf("Aller à Gauche vers (4,2)"); goto adresse_4_2
            ::true -> printf("Aller Bas vers (3,3)"); goto adresse_3_3
        fi
    adresse_4_2:
        if
            ::true -> printf("Aller à Gauche vers (4,1)"); goto adresse_4_1
            ::true -> printf("Aller à Droite vers (4,3)"); goto adresse_4_3
        fi
    adresse_4_1:
        if
            ::true -> printf("Aller à Gauche vers (4,0)"); goto adresse_4_0
            ::true -> printf("Aller à Droite vers (4,2)"); goto adresse_4_2
        fi
    adresse_4_0:
        if
            ::true -> goto final
            ::true -> printf("Aller Bas vers (3,0)"); goto adresse_3_0
            ::true -> printf("Aller à Droite vers (4,1)"); goto adresse_4_1
        fi
    adresse_3_0:
        if
            ::true -> printf("Aller en Haut vers (4,0)"); goto adresse_4_0
        fi
    final:
        printf("Sortie"); assert true

}