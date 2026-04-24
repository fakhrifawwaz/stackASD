public class StackSurat15 {
    
    Surat15[] stack;
    int size;
    int top;

    public StackSurat15(int size) {
        this.size = size;
        stack = new Surat15[size];
        top = -1;
    }

    public boolean isFull() {
        return top == size -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(Surat15 surat) {
        if (!isFull()) {
            top++;
            stack[top] = surat;
        } else {
            System.out.println("Stack penuh! Tidak bisa enerima surat lagi.");
        }
    }

    public Surat15 pop() {
        if (!isEmpty()) {
            Surat15 s = stack[top];
            top--;
            return s;
        } else {
            System.out.println("Stack kosong! Tidak ada surat untuk diproses.");
            return null;
        }
    }

    public Surat15 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack kosong! Tidak ada surat izin.");
            return null;
        }
    }

    public void cariSurat(String nama) {
        boolean ditemukan = false;
        for (int i = top; i >= 0; i--) {
            if (stack[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                System.out.println("Surat ditemukan!");
                System.out.println("ID Surat     : " + stack[i].idSurat);
                System.out.println("Nama         : " + stack[i].namaMahasiswa);
                System.out.println("Kelas        : " + stack[i].kelas);
                System.out.println("Jenis Izin   : " + (stack[i].jenisIzin == 'S' ? "Sakit" : "Izin"));
                System.out.println("Durasi       : " + stack[i].durasi + " hari");
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Surat atas nama \"" + nama + "\" tidak ditemukan.");
        }
    }

    public void print() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i].idSurat + "\t" + stack[i].namaMahasiswa + "\t"
                    + stack[i].kelas + "\t" + stack[i].jenisIzin + "\t" + stack[i].durasi + " hari");
        }
        System.out.println();
    }

}
