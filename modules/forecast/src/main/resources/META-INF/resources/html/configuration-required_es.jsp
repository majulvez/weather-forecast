<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="init.jsp" %>

<article>
    <h3>Requisitos</h3>
    Requisitos para usar este portlet:
    <ul>
        <li>(Requerido) Obtención de los datos del tiempo. Abre una cuenta en <a href="https://darksky.net"
                                                                                   target="_blank">https://darksky.net</a>
            y obten una key
        </li>
        </li>
        <li>(Opcional) Obtención de coordenadas usando Google Maps. Abre una cuenta en <a href="https://maps.google.es"
                                                                                 target="_blank">https://maps.google.es</a>
            y obten un key
        </li>
    </ul>

    <h3>Configuración</h3>
    En la configuración del portlet podrás:
    <ul>
        <li>(Obligatorio) Indicar la localización del lugar sobre el que quieres visualizar el tiempo</li>
        <li>Indicar las unidades a mostrar (celsius vs fahrenheit; kilometros por hora vs millas por hora)</li>
        <li>Indicar las propiedades de red si estás detrás de un proxy</li>
        <li>Indicar el tiempo entre las peticiones al API de DarkSky</li>
        <li>Crear tantas visualizaciones como quieras usando el ADT de liferay</li>
    </ul>

    <div class="alert alert-warning" role="alert">
        El API de DarkSky está limitado a 1000 llamadas diarias (salvo si se paga una subscripción), por
        lo que el valor en la configuración del "tiempo mínimo entre peticiones" es crítico si utilizas la misma key en
        la configuración de distintas instancias del portlet. Por defecto son 120 segundos (2 minutos).
        <br />
        Durante ese intervalo de tiempo, se sirve el objeto cacheado en ehcache.
    </div>

    <h3>Visualización</h3>
    <p>
        El portlet ofrece 2 templates de ejemplo para que puedas hacerte una idea de las infinitas posibilidades que
        hay. Si quieres ver todos los datos que ofrece, crea una nueva template e imprime el valor de la
        variable ${darkSky}
    </p>

    <h3>Modelo de datos</h3>
    <p>
        El modelo de datos del objeto ${darkSky} es el equivalente al json de respuesta (Ver <a
            href="https://darksky.net/dev/docs/response" target="_blank">https://darksky.net/dev/docs/response</a>)
    </p>
</article>