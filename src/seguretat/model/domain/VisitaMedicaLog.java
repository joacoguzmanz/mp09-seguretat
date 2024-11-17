package seguretat.model.domain;

public class VisitaMedicaLog {
    private String algoritmo;
    private String accion;
    private VisitaMedica visitaMedica;

    public String getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public VisitaMedica getVisitaMedica() {
        return visitaMedica;
    }

    public void setVisitaMedica(VisitaMedica visitaMedica) {
        this.visitaMedica = visitaMedica;
    }

    @Override
    public String toString() {
        return "VisitaMedicaLog{" +
                "algoritmo='" + algoritmo + '\'' +
                ", accion='" + accion + '\'' +
                ", visitaMedica=" + visitaMedica +
                '}';
    }
}
