import java.util.ArrayList;

abstract class ArchiveElement {
    String name;
    ArchiveElement parent;

    public ArchiveElement(String name, ArchiveElement parent) throws Exception {
        if (parent instanceof File) {
            throw new Exception(String.format("Το %s δεν μπορεί να είναι αρχείο", parent.getName()));
        }

        if (parent != null) {
            ((Folder)parent).addElem(this);
        }

        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    abstract public float getSize();
}

class Folder extends ArchiveElement {
    ArrayList<ArchiveElement> elems;

    public Folder(String name, ArchiveElement parent) throws Exception {
        super(name, parent);
        this.elems = new ArrayList<ArchiveElement>();
    }

    public void addElem(ArchiveElement elem) {
        elems.add(elem);
    }

    public float getSize() {
        float sum = 0.0F;

        for (ArchiveElement e : elems) {
            sum += e.getSize();
        }

        return sum;
    }
}

class File extends ArchiveElement {
    private float size;

    public File(String name, ArchiveElement parent, float size) throws Exception {
        super(name, parent);
        this.size = size;
    }

    public float getSize() {
        return size;
    }
}

class FileSystem {
    public static void main(String[] args) {
        ArrayList<ArchiveElement> elems = new ArrayList<>();

        try {
            ArchiveElement root = new Folder("Root", null);
            ArchiveElement tmp = new Folder("Tmp", root);
            ArchiveElement backup = new Folder("Backup", tmp);
            ArchiveElement note1 = new File("Note1.txt", tmp, 45.2f);
            ArchiveElement note2 = new File("Note2.txt", backup, 32.6f);
            ArchiveElement note3 = new File("Note3.txt", backup, 12.2f);

            elems.add(root);
            elems.add(tmp);
            elems.add(backup);
            elems.add(note1);
            elems.add(note2);
            elems.add(note3);
        } catch (Exception e) {
            System.out.println(e);
        }

        for (ArchiveElement f : elems) {
            System.out.println(f.name + " has size " + f.getSize());
        }
    }
}