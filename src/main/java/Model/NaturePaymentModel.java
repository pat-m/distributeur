package Model;

public class NaturePaymentModel {
    private int naturePaymentId;
    private int naturePaymentLibelle;

    public NaturePaymentModel(int naturePaymentId, int naturePaymentLibelle) {
        this.naturePaymentId = naturePaymentId;
        this.naturePaymentLibelle = naturePaymentLibelle;
    }

    public int getNaturePaymentId() {
        return naturePaymentId;
    }

    public void setNaturePaymentId(int naturePaymentId) {
        this.naturePaymentId = naturePaymentId;
    }

    public int getNaturePaymentLibelle() {
        return naturePaymentLibelle;
    }

    public void setNaturePaymentLibelle(int naturePaymentLibelle) {
        this.naturePaymentLibelle = naturePaymentLibelle;
    }
}
