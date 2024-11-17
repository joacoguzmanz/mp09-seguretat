package seguretat.model.service;

import seguretat.model.domain.VisitaMedica;
import seguretat.model.domain.VisitaMedicaLog;
import seguretat.model.repository.VisitaMedicaLogRepository;

import java.util.ArrayList;

public class VisitaMedicaService {
    VisitaMedicaLogRepository visitaMedicaLogRepository = null;

    public VisitaMedicaService() {
        visitaMedicaLogRepository = new VisitaMedicaLogRepository();
    }

    public VisitaMedica getVisitaMedicaEncriptadaMD5(VisitaMedica visitaMedica) {
        this.validaVisitaMedica(visitaMedica);
        visitaMedicaLogRepository.addVisitaMedica("MD5", "Original", visitaMedica);

        MD5SecurityService Security = new MD5SecurityService();
        String nombrePacienteEnc = Security.encripta(visitaMedica.getNombrePaciente());
        String diagnosticoEnc = Security.encripta(visitaMedica.getDiagnostico());

        VisitaMedica visitaMedicaEnc = new VisitaMedica();
        visitaMedicaEnc.setIdVisita(visitaMedica.getIdVisita());
        visitaMedicaEnc.setFecha(visitaMedica.getFecha());
        visitaMedicaEnc.setNombreMedico(visitaMedica.getNombreMedico());
        visitaMedicaEnc.setNombrePaciente(nombrePacienteEnc);
        visitaMedicaEnc.setDiagnostico(diagnosticoEnc);

        visitaMedicaLogRepository.addVisitaMedica("MD5", "Encriptado", visitaMedicaEnc);
        return visitaMedicaEnc;
    }

    public VisitaMedica getVisitaMedicaEncriptadaSHA256(VisitaMedica visitaMedica) {
        this.validaVisitaMedica(visitaMedica);
        visitaMedicaLogRepository.addVisitaMedica("SHA256", "Original", visitaMedica);

        SHA256SecurityService Security = new SHA256SecurityService();
        String nombrePacienteEnc = Security.encripta(visitaMedica.getNombrePaciente());
        String diagnosticoEnc = Security.encripta(visitaMedica.getDiagnostico());

        VisitaMedica visitaMedicaEnc = new VisitaMedica();
        visitaMedicaEnc.setIdVisita(visitaMedica.getIdVisita());
        visitaMedicaEnc.setFecha(visitaMedica.getFecha());
        visitaMedicaEnc.setNombreMedico(visitaMedica.getNombreMedico());
        visitaMedicaEnc.setNombrePaciente(nombrePacienteEnc);
        visitaMedicaEnc.setDiagnostico(diagnosticoEnc);

        visitaMedicaLogRepository.addVisitaMedica("SHA256", "Encriptado", visitaMedicaEnc);
        return visitaMedicaEnc;
    }

    public VisitaMedica getVisitaMedicaEncriptadaAES(VisitaMedica visitaMedica) {
        this.validaVisitaMedica(visitaMedica);
        visitaMedicaLogRepository.addVisitaMedica("AES", "Original", visitaMedica);

        AESSecurityService Security = new AESSecurityService();
        String nombrePacienteEnc = Security.encripta(visitaMedica.getNombrePaciente());
        String diagnosticoEnc = Security.encripta(visitaMedica.getDiagnostico());

        VisitaMedica visitaMedicaEnc = new VisitaMedica();
        visitaMedicaEnc.setIdVisita(visitaMedica.getIdVisita());
        visitaMedicaEnc.setFecha(visitaMedica.getFecha());
        visitaMedicaEnc.setNombreMedico(visitaMedica.getNombreMedico());
        visitaMedicaEnc.setNombrePaciente(nombrePacienteEnc);
        visitaMedicaEnc.setDiagnostico(diagnosticoEnc);

        visitaMedicaLogRepository.addVisitaMedica("AES", "Encriptado", visitaMedicaEnc);
        return visitaMedicaEnc;
    }

    public VisitaMedica getVisitaMedicaDesencriptadaAES(VisitaMedica visitaMedicaEnc) {
        AESSecurityService Security = new AESSecurityService();
        String nombrePacienteDesenc = Security.desencripta(visitaMedicaEnc.getNombrePaciente());
        String diagnosticoDesenc = Security.desencripta(visitaMedicaEnc.getDiagnostico());

        VisitaMedica visitaMedicaDesenc = new VisitaMedica();
        visitaMedicaDesenc.setIdVisita(visitaMedicaEnc.getIdVisita());
        visitaMedicaDesenc.setFecha(visitaMedicaEnc.getFecha());
        visitaMedicaDesenc.setNombreMedico(visitaMedicaEnc.getNombreMedico());
        visitaMedicaDesenc.setNombrePaciente(nombrePacienteDesenc);
        visitaMedicaDesenc.setDiagnostico(diagnosticoDesenc);

        visitaMedicaLogRepository.addVisitaMedica("AES", "Desencriptado", visitaMedicaDesenc);
        return visitaMedicaDesenc;
    }

    public ArrayList<VisitaMedicaLog> getLogs() {
        return visitaMedicaLogRepository.getVisitasMedicasLog();
    }

    private void validaVisitaMedica(VisitaMedica visitaMedica) {
        if (visitaMedica == null) {
            throw new RuntimeException("La visita medica no puede ser nula");
        }

        if (visitaMedica.getIdVisita() < 1) {
            throw new RuntimeException("El id de la visita medica debe estar informado");
        }

        if (visitaMedica.getNombreMedico() == null || visitaMedica.getNombreMedico().isEmpty()) {
            throw new RuntimeException("El nombre del medico debe estar informado");
        }

        if (visitaMedica.getNombrePaciente() == null || visitaMedica.getNombrePaciente().isEmpty()) {
            throw new RuntimeException("El nombre del paciente debe estar informado");
        }

        if (visitaMedica.getFecha() == null) {
            throw new RuntimeException("La fecha de la visita medica debe estar informada");
        }

        if (visitaMedica.getDiagnostico() == null || visitaMedica.getDiagnostico().isEmpty()) {
            throw new RuntimeException("El diagnostico debe estar informado");
        }
    }
}
