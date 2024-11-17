package seguretat.view.console;

import seguretat.model.domain.VisitaMedica;
import seguretat.model.domain.VisitaMedicaLog;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class VisitaMedicaView {
    public VisitaMedica getVisitaMedica() {
        String text = null;

        text = JOptionPane.showInputDialog(null, "Id Visita Medica:", "Visita Medica", JOptionPane.PLAIN_MESSAGE);
        int id = getIntByText(text);
        String nombreMedico = JOptionPane.showInputDialog(null, "Nombre Medico:", "Visita Medica", JOptionPane.PLAIN_MESSAGE);
        String nombrePaciente = JOptionPane.showInputDialog(null, "Nombre Paciente:", "Visita Medica", JOptionPane.PLAIN_MESSAGE);
        String diagnostico = JOptionPane.showInputDialog(null, "Diagnostico:", "Visita Medica", JOptionPane.PLAIN_MESSAGE);

        text = JOptionPane.showInputDialog(null, "Fecha (YYYY-MM-DD):", "Visita Medica", JOptionPane.PLAIN_MESSAGE);
        LocalDate fecha = LocalDate.parse(text);

        VisitaMedica visitaMedica = new VisitaMedica();
        visitaMedica.setIdVisita(id);
        visitaMedica.setNombreMedico(nombreMedico);
        visitaMedica.setNombrePaciente(nombrePaciente);
        visitaMedica.setDiagnostico(diagnostico);
        visitaMedica.setFecha(fecha);

        return visitaMedica;
    }

    public void showVisitaMedica(VisitaMedica visitaMedica) {
        JOptionPane.showMessageDialog(null, visitaMedica.toString(), "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showMensaje(String mensaje, boolean esError) {
        if (esError) {
            JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public boolean pedirMasDatos() {
        int response = JOptionPane.showConfirmDialog(null, "¿Querés pedir más datos?", "Confirmación", JOptionPane.YES_NO_OPTION);
        return response == JOptionPane.YES_OPTION;
    }

    public void mostrarLogs(ArrayList<VisitaMedicaLog> logs) {
        if (logs != null && !logs.isEmpty()) {
            StringBuilder logMessages = new StringBuilder(" Listado de logs:\n");
            for (VisitaMedicaLog log : logs) {
                logMessages.append(log.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, logMessages.toString(), "Logs", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay logs", "Logs", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private int getIntByText(String text) {
        int i = 0;

        try {
            i = Integer.parseInt(text);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return i;
    }
}
