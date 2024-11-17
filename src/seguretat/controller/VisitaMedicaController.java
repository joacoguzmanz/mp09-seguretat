package seguretat.controller;

import seguretat.model.domain.VisitaMedica;
import seguretat.model.service.VisitaMedicaService;
import seguretat.view.console.VisitaMedicaView;

public class VisitaMedicaController {
    VisitaMedicaView visitaMedicaView = new VisitaMedicaView();
    VisitaMedicaService visitaMedicaService = new VisitaMedicaService();

    public void inicio() {
        do {
            aplicarSeguridadAES();
            visitaMedicaView.mostrarLogs(visitaMedicaService.getLogs());
        } while (visitaMedicaView.pedirMasDatos());
    }

    private void aplicarSeguridadMD5() {
        try {
            visitaMedicaView.showMensaje("MD5 ------------", false);
            VisitaMedica visitaMedica = visitaMedicaView.getVisitaMedica();
            VisitaMedica visitaMedicaEnc = visitaMedicaService.getVisitaMedicaEncriptadaMD5(visitaMedica);
            visitaMedicaView.showVisitaMedica(visitaMedicaEnc);
        } catch (Exception e) {
            visitaMedicaView.showMensaje("MD5 - " + e.getMessage(), true);
        }
    }

    private void aplicarSeguridadSHA256() {
        try {
            visitaMedicaView.showMensaje("SHA256 ------------", false);
            VisitaMedica visitaMedica = visitaMedicaView.getVisitaMedica();
            VisitaMedica visitaMedicaEnc = visitaMedicaService.getVisitaMedicaEncriptadaSHA256(visitaMedica);
            visitaMedicaView.showVisitaMedica(visitaMedicaEnc);
        } catch (Exception e) {
            visitaMedicaView.showMensaje("SHA256 - " + e.getMessage(), true);
        }
    }

    private void aplicarSeguridadAES() {
        try {
            visitaMedicaView.showMensaje("AES ------------ Encripta", false);
            VisitaMedica visitaMedica = visitaMedicaView.getVisitaMedica();
            VisitaMedica visitaMedicaEnc = visitaMedicaService.getVisitaMedicaEncriptadaAES(visitaMedica);
            visitaMedicaView.showVisitaMedica(visitaMedicaEnc);

            visitaMedicaView.showMensaje("AES ------------ Desencripta", false);
            VisitaMedica visitaMedicaDesenc = visitaMedicaService.getVisitaMedicaDesencriptadaAES(visitaMedicaEnc);
            visitaMedicaView.showVisitaMedica(visitaMedicaDesenc);
        } catch (Exception e) {
            visitaMedicaView.showMensaje("AES - " + e.getMessage(), true);
        }
    }
}
