public class Player {
    private char choice;

    Player() {
        this.choice = '-';
    }

    public void setChoice(char _choice) {
        this.choice = _choice;
    }

    public char getChoice() {
        return this.choice;
    }

    @Override
    public boolean equals(Player obj) {
        if (obj.getChoice() == this.getChoice() && obj.getChoice() != '-' && this.getChoice() != '-')
            return true;
        else
            return false;
    }
}