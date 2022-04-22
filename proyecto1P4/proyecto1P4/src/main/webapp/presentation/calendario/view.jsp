

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="/proyecto1P4/css/estilos.css">
        <link rel="stylesheet" href="/proyecto1P4/css/calendario.css">
        
        <%@ include file="/Header.jsp" %>
    </head>
    <body>
        <h1>Hello Calendar</h1>
        
        <main class="contenedor">
            <section class="mes">
                <h2 class="nombre_mes">Marzo</h2>
            </section>
            
            <section class="dias">
                <div class="dias_item">Lunes</div>
                <div class="dias_item">Martes</div>
                <div class="dias_item">Miercoles</div>
                <div class="dias_item">Jueves</div>
                <div class="dias_item">Viernes</div>
                <div class="dias_item">Sabado</div>
                <div class="dias_item">Domingo</div>
            </section>
            
            <section class="calendario">
                <div class="calendario_dia">1</div>
                <div class="calendario_dia">2</div>
                <div class="calendario_dia">3</div>
                <div class="calendario_dia">4</div>
                <div class="calendario_dia">5</div>
                <div class="calendario_dia">6</div>
                <div class="calendario_dia">7</div>
                <div class="calendario_dia">8</div>
                <div class="calendario_dia">9</div>
                <div class="calendario_dia">10</div>
                <div class="calendario_dia">11</div>
                <div class="calendario_dia">12</div>
                <div class="calendario_dia">13</div>
                <div class="calendario_dia">14</div>
                <div class="calendario_dia">15</div>
                <div class="calendario_dia">16</div>
                <div class="calendario_dia">17</div>
                <div class="calendario_dia">18</div>
                <div class="calendario_dia">19</div>
                <div class="calendario_dia">20</div>
                <div class="calendario_dia">21</div>
                <div class="calendario_dia">22</div>
                <div class="calendario_dia">23</div>
                <div class="calendario_dia">24</div>
                <div class="calendario_dia">25</div>
                <div class="calendario_dia">26</div>
                <div class="calendario_dia">27</div>
                <div class="calendario_dia">28</div>
                <div class="calendario_dia">29</div>
                <div class="calendario_dia">30</div>
                <div class="calendario_dia">31</div>
            </section>
        </main>
    </body>
</html>
