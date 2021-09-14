package se.iths.java21.objects.inteface.Dice;


public class CheatingSixSidedDie extends SuperDie{//den är typen: objekt, själva klassen, superDie och die

    public CheatingSixSidedDie(){
        super(6);
        currentSide = 6;
    }


    @Override//Verifera metoder så vi verklingen erssätter den och inte skapar en ny
    public void roll() {

    }


}
