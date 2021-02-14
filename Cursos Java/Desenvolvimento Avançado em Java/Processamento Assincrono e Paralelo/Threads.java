public class Threads {
    public static void main(String[] args) {
        
        BarraDeCarregamento2 barraDeCarregamento2 = new BarraDeCarregamento2();
        BarraDeCarregamento3 barraDeCarregamento3 = new BarraDeCarregamento3();

        Thread barraDeCarregamento4 = new Thread(new BarraDeCarregamento4());
        Thread barraDeCarregamento5 = new Thread(new BarraDeCarregamento5());

        barraDeCarregamento2.start();
        barraDeCarregamento3.start();
        barraDeCarregamento4.start();
        barraDeCarregamento5.start();

        GerarPDF pdf = new GerarPDF();
        pdf.run();
    }
}

class GerarPDF implements Runnable
{
    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println("Gerando pdf...");
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BarraDeCarregamento implements Runnable
{
    @Override
    public void run() {
        System.out.println("Loading...");

    }
}

class BarraDeCarregamento2 extends Thread
{
    @Override
    public void run() {
        super.run();

        try {
            Thread.sleep(2000);
            System.out.println("2-Running " + this.getName());
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BarraDeCarregamento3 extends Thread
{
    @Override
    public void run() {
        super.run();

        try {
            Thread.sleep(3000);
            System.out.println("3-Running " + this.getName());
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BarraDeCarregamento4 implements Runnable
{
    @Override
    public void run() {
        try {
            Thread.sleep(4000);
            System.out.println("4-Running...");
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BarraDeCarregamento5 implements Runnable
{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("5-Running...");
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}