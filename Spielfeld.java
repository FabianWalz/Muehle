public class Spielfeld {

    private final static int anzZeilen = 7;
    private final static int anzSpalten = 7;

    //private int moveCounter = 0;
    public enum Belegung {UNGÜL, UNBES, WEISS, SCHWZ}
    public Belegung[][] spielfeld = new Belegung[anzZeilen][anzSpalten];
    public Spielfeld() {
        for (int zeile = 0; zeile < anzZeilen; zeile++) {
            for (int spalte = 0; spalte < anzSpalten; spalte++) {
                this.spielfeld[zeile][spalte] = Belegung.UNGÜL;
            }
        }

        this.spielfeld[0][0] = Belegung.UNBES;
        this.spielfeld[0][3] = Belegung.UNBES;
        this.spielfeld[0][6] = Belegung.UNBES;
        this.spielfeld[1][1] = Belegung.UNBES;
        this.spielfeld[1][3] = Belegung.UNBES;
        this.spielfeld[1][5] = Belegung.UNBES;
        this.spielfeld[2][2] = Belegung.UNBES;
        this.spielfeld[2][3] = Belegung.UNBES;
        this.spielfeld[2][4] = Belegung.UNBES;
        this.spielfeld[3][0] = Belegung.UNBES;
        this.spielfeld[3][1] = Belegung.UNBES;
        this.spielfeld[3][2] = Belegung.UNBES;
        this.spielfeld[3][4] = Belegung.UNBES;
        this.spielfeld[3][5] = Belegung.UNBES;
        this.spielfeld[3][6] = Belegung.UNBES;
        this.spielfeld[4][2] = Belegung.UNBES;
        this.spielfeld[4][3] = Belegung.UNBES;
        this.spielfeld[4][4] = Belegung.UNBES;
        this.spielfeld[5][1] = Belegung.UNBES;
        this.spielfeld[5][3] = Belegung.UNBES;
        this.spielfeld[5][5] = Belegung.UNBES;
        this.spielfeld[5][3] = Belegung.UNBES;
        this.spielfeld[6][0] = Belegung.UNBES;
        this.spielfeld[6][3] = Belegung.UNBES;
        this.spielfeld[6][6] = Belegung.UNBES;
        display();
    }

    // Ausgabe 2D-Array UNBES/UNGÜL
    public void display() {
            for (int zeile = 0; zeile < anzZeilen; zeile++) {
                for (int spalte = 0; spalte < anzSpalten; spalte++) {
                    System.out.print(this.spielfeld[zeile][spalte] + " ");
                }
                System.out.println("");
            }
        }

    // putStone während der Setzphase
    public boolean putStone(Belegung farbe, int zeile, int spalte) {
        boolean ergebnis = false;
        if (this.spielfeld[zeile][spalte] == Belegung.UNBES) {
            this.spielfeld[zeile][spalte] = farbe;
            ergebnis = true;
            //moveCounter++;
        } else {
            ergebnis = false;
        }
        return (ergebnis);
    }

    // putStone in der Sprungphase
    public boolean putStone(Belegung farbe, int vonZeile, int vonSpalte, int nachZeile, int nachSpalte) {
        boolean ergebnis = false;
        if (   this.spielfeld[vonZeile][vonSpalte] == farbe
            && this.spielfeld[nachZeile][nachSpalte] == Belegung.UNBES) {
            this.spielfeld[vonZeile][vonSpalte] = Belegung.UNBES;
            this.spielfeld[nachZeile][nachSpalte] = farbe;
            //moveCounter++;
            ergebnis = true;
        } else {
            ergebnis = false;
        }
        return (ergebnis);
    }

    //Stein entfernen
    public boolean removeStone(Belegung farbe, int zeile, int spalte) {
        boolean ergebnis = false;
        if (this.spielfeld[zeile][spalte] == farbe) {
            this.spielfeld[zeile][spalte] = Belegung.UNBES;
            ergebnis = true;
        }
        return ergebnis;
    }

    // Zugphase; Steine auf benachbarte Felder ziehen
    public boolean moveStone(Belegung farbe, int vonZeile, int vonSpalte, int nachZeile, int nachSpalte) {
        boolean ergebnis = false;
        if (    (this.spielfeld[vonZeile][vonSpalte]   == farbe)
             && (this.spielfeld[nachZeile][nachSpalte] == Belegung.UNBES)
             && isNeighbour(vonZeile, vonSpalte, nachZeile, nachSpalte)) {
            this.spielfeld[vonZeile][vonSpalte] = Belegung.UNBES;
            this.spielfeld[nachZeile][nachSpalte] = farbe;
            ergebnis = true;
        }
        return ergebnis;
    }

    // Zugphase; Abfrage, ob benachbartes Feld ein Nachbar ist
    public boolean isNeighbour(int vonZeile, int vonSpalte, int nachZeile, int nachSpalte){
       boolean ergebnis = false;

       if (vonZeile == 0 && vonSpalte == 0) {
           ergebnis = ergebnis || (nachZeile == 0 && nachSpalte == 3)
                               || (nachZeile == 3 && nachSpalte == 0);
       } else if (vonZeile == 0 && vonSpalte == 3) {
           ergebnis = ergebnis || (nachZeile == 0 && nachSpalte == 0)
                   || (nachZeile == 0 && nachSpalte == 6)
                   || (nachZeile == 1 && nachSpalte == 3);
       } else if (vonZeile == 0 && vonSpalte == 6) {
           ergebnis = ergebnis || (nachZeile == 0 && nachSpalte == 3)
                   || (nachZeile == 3 && nachSpalte == 6);
       } else if (vonZeile == 1 && vonSpalte == 1) {
           ergebnis = ergebnis || (nachZeile == 1 && nachSpalte == 3)
                   || (nachZeile == 3 && nachSpalte == 1);
       } else if (vonZeile == 1 && vonSpalte == 3) {
           ergebnis = ergebnis || (nachZeile == 1 && nachSpalte == 1)
                   || (nachZeile == 1 && nachSpalte == 5)
                   || (nachZeile == 0 && nachSpalte == 3)
                   || (nachZeile == 2 && nachSpalte == 3);
       } else if (vonZeile == 1 && vonSpalte == 5) {
           ergebnis = ergebnis || (nachZeile == 1 && nachSpalte == 3)
                   || (nachZeile == 3 && nachSpalte == 5);
       } else if (vonZeile == 2 && vonSpalte == 2) {
           ergebnis = ergebnis || (nachZeile == 2 && nachSpalte == 3)
                   || (nachZeile == 3 && nachSpalte == 2);
       } else if (vonZeile == 2 && vonSpalte == 3) {
           ergebnis = ergebnis || (nachZeile == 2 && nachSpalte == 2)
                   || (nachZeile == 1 && nachSpalte == 3)
                   || (nachZeile == 2 && nachSpalte == 4);
       } else if (vonZeile == 2 && vonSpalte == 4) {
           ergebnis = ergebnis || (nachZeile == 2 && nachSpalte == 3)
                   || (nachZeile == 3 && nachSpalte == 4);
       } else if (vonZeile == 3 && vonSpalte == 0) {
            ergebnis = ergebnis || (nachZeile == 0 && nachSpalte == 0)
                    || (nachZeile == 3 && nachSpalte == 1)
                    || (nachZeile == 0 && nachSpalte == 6);
        } else if (vonZeile == 3 && vonSpalte == 1) {
           ergebnis = ergebnis || (nachZeile == 3 && nachSpalte == 0)
                   || (nachZeile == 3 && nachSpalte == 2)
                   || (nachZeile == 5 && nachSpalte == 1)
                   || (nachZeile == 1 && nachSpalte == 1);
       } else if (vonZeile == 3 && vonSpalte == 2) {
           ergebnis = ergebnis || (nachZeile == 3 && nachSpalte == 1)
                   || (nachZeile == 2 && nachSpalte == 2)
                   || (nachZeile == 4 && nachSpalte == 2);
       } else if (vonZeile == 3 && vonSpalte == 4) {
           ergebnis = ergebnis || (nachZeile == 3 && nachSpalte == 5)
                   || (nachZeile == 2 && nachSpalte == 4)
                   || (nachZeile == 4 && nachSpalte == 4);
       } else if (vonZeile == 3 && vonSpalte == 5) {
           ergebnis = ergebnis || (nachZeile == 3 && nachSpalte == 4)
                   || (nachZeile == 1 && nachSpalte == 5)
                   || (nachZeile == 5 && nachSpalte == 5);
       } else if (vonZeile == 3 && vonSpalte == 6) {
           ergebnis = ergebnis || (nachZeile == 3 && nachSpalte == 5)
                   || (nachZeile == 0 && nachSpalte == 6)
                   || (nachZeile == 6 && nachSpalte == 6);
       } else if (vonZeile == 4 && vonSpalte == 2) {
           ergebnis = ergebnis || (nachZeile == 4 && nachSpalte == 3)
                   || (nachZeile == 3 && nachSpalte == 2);
       } else if (vonZeile == 4 && vonSpalte == 3) {
           ergebnis = ergebnis || (nachZeile == 4 && nachSpalte == 2)
                   || (nachZeile == 4 && nachSpalte == 4)
                   || (nachZeile == 5 && nachSpalte == 3);
       } else if (vonZeile == 4 && vonSpalte == 4) {
           ergebnis = ergebnis || (nachZeile == 4 && nachSpalte == 3)
                   || (nachZeile == 3 && nachSpalte == 4);
       } else if (vonZeile == 5 && vonSpalte == 1) {
           ergebnis = ergebnis || (nachZeile == 5 && nachSpalte == 3)
                   || (nachZeile == 3 && nachSpalte == 1);
       } else if (vonZeile == 5 && vonSpalte == 3) {
           ergebnis = ergebnis || (nachZeile == 5 && nachSpalte == 1)
                   || (nachZeile == 5 && nachSpalte == 5)
                   || (nachZeile == 6 && nachSpalte == 3);
       } else if (vonZeile == 5 && vonSpalte == 5) {
           ergebnis = ergebnis || (nachZeile == 5 && nachSpalte == 3)
                   || (nachZeile == 3 && nachSpalte == 5);
       } else if (vonZeile == 6 && vonSpalte == 0) {
           ergebnis = ergebnis || (nachZeile == 3 && nachSpalte == 0)
                   || (nachZeile == 6 && nachSpalte == 3);
       } else if (vonZeile == 6 && vonSpalte == 3) {
           ergebnis = ergebnis || (nachZeile == 6 && nachSpalte == 0)
                   || (nachZeile == 5 && nachSpalte == 3)
                   || (nachZeile == 6 && nachSpalte == 6);
       } else if (vonZeile == 6 && vonSpalte == 6) {
           ergebnis = ergebnis || (nachZeile == 6 && nachSpalte == 3)
                   || (nachZeile == 3 && nachSpalte == 6);
       }
        return ergebnis;
    }

    // Anzahl Züge
    //public int getMoveCounter() {
    //    return this.moveCounter;
    //}

    // Abfrage, ob Mühle vorliegt
    public boolean isMillComplete(Belegung farbe, int zeile, int spalte) {
        boolean ergebnis = false;
        if (zeile == 0 && spalte == 0) {
            if (spielfeld[0][0] == farbe
                    && ((spielfeld[0][3] == farbe && spielfeld[0][6] == farbe)
                    || (spielfeld[3][0] == farbe && spielfeld[6][0] == farbe))
            ) ergebnis = true;
        } else if (zeile == 0 && spalte == 3) {
            if (spielfeld[0][3] == farbe
                    && ((spielfeld[0][0] == farbe && spielfeld[0][6] == farbe)
                    || (spielfeld[1][3] == farbe && spielfeld[2][3] == farbe))
            ) ergebnis = true;
        } else if (zeile == 0 && spalte == 6) {
            if (spielfeld[0][6] == farbe
                    && ((spielfeld[0][0] == farbe && spielfeld[0][3] == farbe)
                    || (spielfeld[3][6] == farbe && spielfeld[6][6] == farbe))
            ) ergebnis = true;
        } else if (zeile == 1 && spalte == 1) {
            if (spielfeld[1][1] == farbe
                    && ((spielfeld[1][3] == farbe && spielfeld[1][5] == farbe)
                    || (spielfeld[3][1] == farbe && spielfeld[5][1] == farbe))
            ) ergebnis = true;
        } else if (zeile == 1 && spalte == 3) {
            if (spielfeld[1][3] == farbe
                    && ((spielfeld[0][3] == farbe && spielfeld[2][3] == farbe)
                    || (spielfeld[1][1] == farbe && spielfeld[1][5] == farbe))
            ) ergebnis = true;
        } else if (zeile == 1 && spalte == 5) {
            if (spielfeld[1][5] == farbe
                    && ((spielfeld[1][3] == farbe && spielfeld[1][1] == farbe)
                    || (spielfeld[3][5] == farbe && spielfeld[5][5] == farbe))
            ) ergebnis = true;
        } else if (zeile == 2 && spalte == 2) {
            if (spielfeld[2][2] == farbe
                    && ((spielfeld[2][3] == farbe && spielfeld[2][4] == farbe)
                    || (spielfeld[3][2] == farbe && spielfeld[4][2] == farbe))
            ) ergebnis = true;
        } else if (zeile == 2 && spalte == 3) {
            if (spielfeld[2][3] == farbe
                    && ((spielfeld[2][2] == farbe && spielfeld[2][4] == farbe)
                    || (spielfeld[0][3] == farbe && spielfeld[1][3] == farbe))
            ) ergebnis = true;
        } else if (zeile == 2 && spalte == 4) {
            if (spielfeld[2][4] == farbe
                    && ((spielfeld[2][2] == farbe && spielfeld[2][3] == farbe)
                    || (spielfeld[3][3] == farbe && spielfeld[4][4] == farbe))
            ) ergebnis = true;
        } else if (zeile == 3 && spalte == 0) {
            if (spielfeld[3][0] == farbe
                    && ((spielfeld[0][0] == farbe && spielfeld[6][0] == farbe)
                    || (spielfeld[3][1] == farbe && spielfeld[3][2] == farbe))
            ) ergebnis = true;
        } else if (zeile == 3 && spalte == 1) {
            if (spielfeld[3][1] == farbe
                    && ((spielfeld[3][0] == farbe && spielfeld[3][2] == farbe)
                    || (spielfeld[1][1] == farbe && spielfeld[5][1] == farbe))
            ) ergebnis = true;
        } else if (zeile == 3 && spalte == 2) {
            if (spielfeld[3][2] == farbe
                    && ((spielfeld[3][0] == farbe && spielfeld[3][1] == farbe)
                    || (spielfeld[2][2] == farbe && spielfeld[4][2] == farbe))
            ) ergebnis = true;
        } else if (zeile == 3 && spalte == 4) {
            if (spielfeld[3][4] == farbe
                    && ((spielfeld[3][5] == farbe && spielfeld[3][6] == farbe)
                    || (spielfeld[2][4] == farbe && spielfeld[4][4] == farbe))
            ) ergebnis = true;
        } else if (zeile == 3 && spalte == 5) {
            if (spielfeld[3][5] == farbe
                    && ((spielfeld[3][4] == farbe && spielfeld[3][6] == farbe)
                    || (spielfeld[1][5] == farbe && spielfeld[5][5] == farbe))
            ) ergebnis = true;
        } else if (zeile == 3 && spalte == 6) {
            if (spielfeld[3][6] == farbe
                    && ((spielfeld[0][6] == farbe && spielfeld[6][6] == farbe)
                    || (spielfeld[3][5] == farbe && spielfeld[3][4] == farbe))
            ) ergebnis = true;
        } else if (zeile == 4 && spalte == 2) {
            if (spielfeld[4][2] == farbe
                    && ((spielfeld[3][2] == farbe && spielfeld[2][2] == farbe)
                    || (spielfeld[4][3] == farbe && spielfeld[4][4] == farbe))
            )ergebnis = true;
        }else if (zeile == 4 && spalte == 3) {
            if (spielfeld[4][3] == farbe
                    && ((spielfeld[4][2] == farbe && spielfeld[5][4] == farbe)
                    || (spielfeld[5][3] == farbe && spielfeld[6][3] == farbe))
            ) ergebnis = true;
        } else if (zeile == 4 && spalte == 4) {
            if (spielfeld[4][4] == farbe
                    && ((spielfeld[4][2] == farbe && spielfeld[4][3] == farbe)
                    || (spielfeld[3][4] == farbe && spielfeld[2][4] == farbe))
            ) ergebnis = true;
        } else if (zeile == 5 && spalte == 1) {
            if (spielfeld[5][1] == farbe
                    && ((spielfeld[5][3] == farbe && spielfeld[5][5] == farbe)
                    || (spielfeld[3][1] == farbe && spielfeld[1][1] == farbe))
            ) ergebnis = true;
        } else if (zeile == 5 && spalte == 3) {
            if (spielfeld[5][3] == farbe
                    && ((spielfeld[5][1] == farbe && spielfeld[5][5] == farbe)
                    || (spielfeld[4][3] == farbe && spielfeld[6][3] == farbe))
            ) ergebnis = true;
        } else if (zeile == 5 && spalte == 5) {
            if (spielfeld[5][5] == farbe
                    && ((spielfeld[5][1] == farbe && spielfeld[5][3] == farbe)
                    || (spielfeld[3][5] == farbe && spielfeld[1][5] == farbe))
            ) ergebnis = true;
        } else if (zeile == 6 && spalte == 0) {
            if (spielfeld[6][0] == farbe
                    && ((spielfeld[3][0] == farbe && spielfeld[0][0] == farbe)
                    || (spielfeld[6][3] == farbe && spielfeld[6][6] == farbe))
            ) ergebnis = true;
        } else if (zeile == 6 && spalte == 3) {
            if (spielfeld[6][3] == farbe
                    && ((spielfeld[6][0] == farbe && spielfeld[6][6] == farbe)
                    || (spielfeld[5][3] == farbe && spielfeld[4][3] == farbe))
            ) ergebnis = true;
        } else if (zeile == 6 && spalte == 6) {
            if (spielfeld[6][6] == farbe
                    && ((spielfeld[6][0] == farbe && spielfeld[6][3] == farbe)
                    || (spielfeld[3][6] == farbe && spielfeld[0][6] == farbe))
            ) ergebnis = true;
        }
        else {
            System.out.println("Es liegt keine Mühle vor.");
        }
        return ergebnis;
    }


    // Zugphase; Abfrage, ob ein Zug möglich ist
    public boolean isMovePossible(Belegung farbe) {
        boolean ergebnis = false;
        for (int zeile = 0; zeile < anzZeilen; zeile++) {
            for (int spalte = 0; spalte < anzSpalten; spalte++) {
                if (this.spielfeld[zeile][spalte] == farbe) {
                    ergebnis = ergebnis || hasEmptyNeighbour(zeile, spalte);
                }
            }
        }
        return ergebnis;
    }

    // Zugphase; Abfrage, ob ein Nachbar frei ist
    public boolean hasEmptyNeighbour(int zeile, int spalte) {
        boolean ergebnis = false;

        if (zeile == 0 && spalte == 0) {
            ergebnis = ergebnis || this.spielfeld[0][3] == Belegung.UNBES
                    || this.spielfeld[3][0] == Belegung.UNBES;
        } else if (zeile == 0 && spalte == 3) {
            ergebnis = ergebnis || this.spielfeld[0][0] == Belegung.UNBES
                    || this.spielfeld[0][6] == Belegung.UNBES
                    || this.spielfeld[1][3] == Belegung.UNBES;
        } else if (zeile == 0 && spalte == 6) {
            ergebnis = ergebnis || this.spielfeld[0][3] == Belegung.UNBES
                    || this.spielfeld[3][6] == Belegung.UNBES;
        } else if (zeile == 1 && spalte == 1) {
            ergebnis = ergebnis || this.spielfeld[3][1] == Belegung.UNBES
                    || this.spielfeld[1][3] == Belegung.UNBES;
        } else if (zeile == 1 && spalte == 3) {
            ergebnis = ergebnis || this.spielfeld[1][1] == Belegung.UNBES
                    || this.spielfeld[1][5] == Belegung.UNBES
                    || this.spielfeld[2][3] == Belegung.UNBES;
        } else if (zeile == 1 && spalte == 5) {
            ergebnis = ergebnis || this.spielfeld[1][3] == Belegung.UNBES
                    || this.spielfeld[3][5] == Belegung.UNBES;
        } else if (zeile == 2 && spalte == 2) {
            ergebnis = ergebnis || this.spielfeld[2][3] == Belegung.UNBES
                    || this.spielfeld[3][1] == Belegung.UNBES;
        } else if (zeile == 2 && spalte == 3) {
            ergebnis = ergebnis || this.spielfeld[2][2] == Belegung.UNBES
                    || this.spielfeld[2][4] == Belegung.UNBES
                    || this.spielfeld[1][3] == Belegung.UNBES;
        } else if (zeile == 2 && spalte == 4) {
            ergebnis = ergebnis || this.spielfeld[2][3] == Belegung.UNBES
                    || this.spielfeld[3][4] == Belegung.UNBES;
        } else if (zeile == 3 && spalte == 0) {
            ergebnis = ergebnis || this.spielfeld[0][0] == Belegung.UNBES
                    || this.spielfeld[0][6] == Belegung.UNBES
                    || this.spielfeld[3][1] == Belegung.UNBES;
        } else if (zeile == 3 && spalte == 1) {
            ergebnis = ergebnis || this.spielfeld[3][0] == Belegung.UNBES
                    || this.spielfeld[3][2] == Belegung.UNBES
                    || this.spielfeld[5][1] == Belegung.UNBES
                    || this.spielfeld[1][1] == Belegung.UNBES;
        } else if (zeile == 3 && spalte == 2) {
            ergebnis = ergebnis || this.spielfeld[3][1] == Belegung.UNBES
                    || this.spielfeld[2][2] == Belegung.UNBES
                    || this.spielfeld[4][2] == Belegung.UNBES;
        } else if (zeile == 3 && spalte == 4) {
            ergebnis = ergebnis || this.spielfeld[3][5] == Belegung.UNBES
                    || this.spielfeld[2][4] == Belegung.UNBES
                    || this.spielfeld[4][4] == Belegung.UNBES;
        } else if (zeile == 3 && spalte == 5) {
            ergebnis = ergebnis || this.spielfeld[3][3] == Belegung.UNBES
                    || this.spielfeld[3][6] == Belegung.UNBES
                    || this.spielfeld[5][5] == Belegung.UNBES
                    || this.spielfeld[1][5] == Belegung.UNBES;
        } else if (zeile == 3 && spalte == 6) {
            ergebnis = ergebnis || this.spielfeld[3][5] == Belegung.UNBES
                    || this.spielfeld[0][6] == Belegung.UNBES
                    || this.spielfeld[6][6] == Belegung.UNBES;
        } else if (zeile == 4 && spalte == 2) {
            ergebnis = ergebnis || this.spielfeld[4][3] == Belegung.UNBES
                    || this.spielfeld[3][2] == Belegung.UNBES;
        } else if (zeile == 4 && spalte == 3) {
            ergebnis = ergebnis || this.spielfeld[4][2] == Belegung.UNBES
                    || this.spielfeld[4][4] == Belegung.UNBES
                    || this.spielfeld[5][3] == Belegung.UNBES;
        } else if (zeile == 4 && spalte == 4) {
            ergebnis = ergebnis || this.spielfeld[4][3] == Belegung.UNBES
                    || this.spielfeld[3][4] == Belegung.UNBES;
        } else if (zeile == 5 && spalte == 1) {
            ergebnis = ergebnis || this.spielfeld[5][3] == Belegung.UNBES
                    || this.spielfeld[3][1] == Belegung.UNBES;
        } else if (zeile == 5 && spalte == 1) {
            ergebnis = ergebnis || this.spielfeld[5][3] == Belegung.UNBES
                    || this.spielfeld[3][1] == Belegung.UNBES;
        } else if (zeile == 5 && spalte == 3) {
            ergebnis = ergebnis || this.spielfeld[5][1] == Belegung.UNBES
                    || this.spielfeld[5][5] == Belegung.UNBES
                    || this.spielfeld[6][3] == Belegung.UNBES;
        } else if (zeile == 5 && spalte == 5) {
            ergebnis = ergebnis || this.spielfeld[5][3] == Belegung.UNBES
                    || this.spielfeld[3][5] == Belegung.UNBES;
        } else if (zeile == 6 && spalte == 0) {
            ergebnis = ergebnis || this.spielfeld[6][3] == Belegung.UNBES
                    || this.spielfeld[3][0] == Belegung.UNBES;
        } else if (zeile == 6 && spalte == 3) {
            ergebnis = ergebnis || this.spielfeld[6][0] == Belegung.UNBES
                    || this.spielfeld[5][3] == Belegung.UNBES
                    || this.spielfeld[5][6] == Belegung.UNBES;
        } else if (zeile == 6 && spalte == 6) {
            ergebnis = ergebnis || this.spielfeld[6][3] == Belegung.UNBES
                    || this.spielfeld[3][6] == Belegung.UNBES;
        }
        return (ergebnis);
    }
}


