package seguretat.model.domain;

import java.time.LocalDate;

public class VisitaMedica {
    private int IdVisita;
    private String nombrePaciente;
    private String nombreMedico;
    private LocalDate fecha;
    private String diagnostico;

    public int getIdVisita() {
        return IdVisita;
    }

    public void setIdVisita(int idVisita) {
        IdVisita = idVisita;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Override
    public String toString() {
        return "VisitaMedica{" +
                "IdVisita=" + IdVisita +
                ", nombrePaciente='" + nombrePaciente + '\'' +
                ", nombreMedico='" + nombreMedico + '\'' +
                ", fecha=" + fecha +
                ", diagnostico='" + diagnostico + '\'' +
                '}';
    }
}
