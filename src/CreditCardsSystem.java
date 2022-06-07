import java.util.ArrayList;

class Card {
    ArrayList<Integer> id = new ArrayList<>();

    public Card(String id) {
        for (char digit : id.toCharArray()) {
            this.id.add(Character.getNumericValue(digit));
        }
    }

    public ArrayList<Integer> getId() {
        return id;
    }

    public boolean checkValid() {
        ArrayList<Integer> newId = new ArrayList<>();

        for (int i=8; i>=0; i--) {
            newId.add(id.get(i));
        }

        for (int i=0; i<newId.size(); i+=2) {
            int doubleNumber = newId.get(i) * 2;
            if (doubleNumber > 9) {
                doubleNumber = (doubleNumber / 10) + (doubleNumber % 10);
            }
            newId.set(i, doubleNumber);
        }

        int sum = 0;

        for (Integer number : newId) {
            sum += number;
        }

        int checkNumber = 10 - (sum % 10);

        if (checkNumber == id.get(9)) {
            return true;
        }

        return false;
    }
}

class CreditCard extends Card {

    public CreditCard(String id) {
        super(id);
    }

}

class DebitCard extends Card {
    String csv;

    public DebitCard(String id, String csv) {
        super(id);
        this.csv = csv;
    }

    @Override
    public boolean checkValid() {
        StringBuffer firstChars = new StringBuffer();
        for (int i=0; i<3; i++) {
            firstChars.append(super.getId().get(i));
        }

        if (super.checkValid() && csv.equals(String.valueOf(firstChars))) {
            return true;
        }

        return false;
    }
}

class CreditCardsSystem {
    public static void main(String[] args) {
        Card credit1 = new CreditCard("1234567897");
        Card credit2 = new CreditCard("1234567898");
        Card debit1 = new DebitCard("1234567897", "123");
        Card debit2 = new DebitCard("1234567897", "122");

        System.out.println(credit1.checkValid());
        System.out.println(credit2.checkValid());
        System.out.println(debit1.checkValid());
        System.out.println(debit2.checkValid());
    }
}