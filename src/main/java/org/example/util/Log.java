
package util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Clase utilitaria para centralizar el registro de logs en la aplicación,
 * utilizando Log4j2. Permite registrar mensajes en distintos niveles
 * (INFO, DEBUG, WARN, ERROR) y agregar excepciones si es necesario.
 */
public class Log {
    /** Logger estático principal utilizado por toda la aplicación. */
    private static final Logger logger = LogManager.getLogger("AppLogger");

    /**
     * Escribe un mensaje en el log con un nivel específico, y opcionalmente una excepción.
     * @param mensaje El mensaje a registrar.
     * @param ex La excepción asociada (puede ser {@code null} si no hay excepción).
     * @param nivel El nivel de log (por ejemplo: {@code Level.INFO}, {@code Level.ERROR}).
     */
    public static void escribirLog(String mensaje, Throwable ex, Level nivel) {
        if (ex == null) {
            logger.log(nivel, mensaje);
        } else {
            logger.log(nivel, mensaje, ex);
        }
    }

    /**
     * Registra un mensaje con nivel INFO.
     *
     * @param mensaje El mensaje a registrar.
     */
    public static void info(String mensaje) {
        escribirLog(mensaje, null, Level.INFO);
    }

    /**
     * Registra un mensaje con nivel ERROR, incluyendo una excepción.
     *
     * @param mensaje El mensaje a registrar.
     * @param ex La excepción asociada al error.
     */
    public static void error(String mensaje, Throwable ex) {
        escribirLog(mensaje, ex, Level.ERROR);
    }

    /**
     * Registra un mensaje con nivel DEBUG.
     *
     * @param mensaje El mensaje a registrar.
     */
    public static void debug(String mensaje) {
        escribirLog(mensaje, null, Level.DEBUG);
    }

    /**
     * Registra un mensaje con nivel WARN (advertencia).
     *
     * @param mensaje El mensaje a registrar.
     */
    public static void warn(String mensaje) {
        escribirLog(mensaje, null, Level.WARN);
    }
}

