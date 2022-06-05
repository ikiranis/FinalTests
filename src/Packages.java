import java.util.ArrayList;
import java.util.Random;

class Address {
    private String road;
    private int number;
    private String code;

    public Address(String road, int number, String code) {
        this.road = road;
        this.number = number;
        this.code = code;
    }

    public String getRoad() {
        return road;
    }

    public int getNumber() {
        return number;
    }

    public String getCode() {
        return code;
    }
}

class Package {
    private String sender;
    private String receiver;
    private Address receiverAddress;
    private double weight;

    public Package(String sender, String receiver, Address receiverAddress, double weight) {
        this.sender = sender;
        this.receiver = receiver;
        this.receiverAddress = receiverAddress;
        this.weight = weight;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public Address getReceiverAddress() {
        return receiverAddress;
    }

    public double getWeight() {
        return weight;
    }

    public double getCost() {
        if (weight <= 5000) {
            return 0.4 * (weight / 100);
        } else {
            return 20 + (2.5 * ((weight - 5000) / 1000));
        }
    }
}

class ExpressPackage extends Package {
    private int priority;

    public ExpressPackage(String sender, String receiver, Address receiverAddress, double weight, int priority) {
        super(sender, receiver, receiverAddress, weight);
        this.priority = priority;
    }

    @Override
    public double getCost() {
        if (getWeight() <= 3000) {
            return super.getCost() + (5 * priority);
        } else {
            return super.getCost() + (10 * priority);
        }
    }
}

class Packages {
    public static void main(String[] args) {
        Random random = new Random();
        String[] sr = {"ΓΕΩΡΓΙΟΥ Π.", "ΠΑΠΑΔΟΠΟΥΛΟΣ Ε.", "ΑΜΑΝΑΤΙΔΗΣ Μ.", "ΑΠΟΣΤΟΛΟΠΟΥΛΟΣ Ι."};
        Address[] ad = {new Address("Μιλήτου", 5, "26631"),
                        new Address("Ιασίου", 18, "24132"),
                        new Address("Ψαθά", 108, "10181"),
                        new Address("Αχιλλέως", 17, "31151")
        };

        ArrayList<Package> packagesList = new ArrayList<>();

        for(int i=0; i<30; i++) {
            int senderId = random.nextInt(4);
            int receiverId;
            do {
                receiverId = random.nextInt(4);
            } while (receiverId == senderId);
            int receiverAddressId = random.nextInt(4);
            int weight = random.nextInt(30000) + 50;
            int priority = random.nextInt(3) + 1;

            if(i<15) {
                packagesList.add(new Package(sr[senderId], sr[receiverId], ad[receiverAddressId], weight));
            } else {
                packagesList.add(new ExpressPackage(sr[senderId], sr[receiverId], ad[receiverAddressId], weight, priority));
            }
        }

        double sum = 0;
        int counter = 0;

        for (Package p : packagesList) {
            System.out.println(p.getSender() + " -> " + p.getReceiver());
            if(p.getReceiver().equals(sr[1])) {
                sum += p.getCost();
                counter++;
            }
        }

        if (sum > 0) {
            System.out.println("Average cost: " + (sum / counter));
        } else {
            System.out.println("Δεν βρέθηκαν εγγραφές");
        }
    }
}