import mpi.*;

class recv_test {

    public static void main(String[] args) throws MPIException {
        MPI.Init(args);

        Comm comm = MPI.COMM_WORLD;
        int me = comm.getRank();
        int data=114514;

        if ((me == 0)||(me == 2)){
            comm.send(data, 5, MPI.DOUBLE, 1, 1);
            System.out.println("Sent from"+ me);
        } else if (me == 1) {
            Status status = comm.recv(data, 20, MPI.DOUBLE, MPI.ANY_SOURCE, 1);
            Status status2 = comm.recv(data, 20, MPI.DOUBLE, MPI.ANY_SOURCE, 1);
            int count = status.getCount(MPI.DOUBLE);
            int src = status.getSource();
            System.out.println("Received "+ count +" values from "+ src);
            int count2 = status2.getCount(MPI.DOUBLE);
            int src2 = status2.getSource();
            System.out.println("Received "+ count2 +" values from "+ src2);
    }

        MPI.Finalize();
    }


}
