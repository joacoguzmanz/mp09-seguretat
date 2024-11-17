package seguretat.model.repository;

import seguretat.model.domain.VisitaMedica;
import seguretat.model.domain.VisitaMedicaLog;

import java.util.ArrayList;

public class VisitaMedicaLogRepository {
    private ArrayList<VisitaMedicaLog> visitas = new ArrayList<VisitaMedicaLog>();

    public void addVisitaMedica(String algoritmo, String accion, VisitaMedica visitaMedica) {
        VisitaMedicaLog visitaMedicaLog = new VisitaMedicaLog();
        visitaMedicaLog.setAlgoritmo(algoritmo);
        visitaMedicaLog.setAccion(accion);
        visitaMedicaLog.setVisitaMedica(visitaMedica);
        visitas.add(visitaMedicaLog);
    }

    public ArrayList<VisitaMedicaLog> getVisitasMedicasLog() {
        return visitas;
    }
}
