/*Debe incluir el método que reciba un typeId (int) y retorne la
 colección de objetos Airplane asociados a dicho tipo con todos sus
  datos.  Es obligagorio utilizar la clase JdbcTemplate y 
  ResultSetExtractor. */

import java.util.List;

import com.zenithsky.oparea.lab.domain.Airplane;

public class AirplaneData{

    private final JdbcTemplate jdbcTemplate;

    PeliculaData(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
    }

    public List<Airplane> findAirplanesByTypeId(int typeId){
        String sqlSelect = """
                    SELECT
                    a.airplane_id,
                    a.capacity,
                    a.type_id,
                    t.identifier,
                    t.description,
                    a.airline_id,
                    al.iata,
                    al.airlinename,
                    al.base_airport
                FROM airplane a
                INNER JOIN airplane_type t
                    ON a.type_id = t.type_id
                LEFT JOIN airline al
                    ON a.airline_id = al.airline_id
                WHERE a.type_id = ?
                """;
                title = title.toLowerCase();
                genre = genre.toLowerCase();

            //esto es para pasarle el titulo y genero
                String titleLike = (title == null || title == "" ? "" : "%" +title.trim() +"%");
                String genreLike = (genre == null || genre == "" ? "" : "%" +genre.trim()+"%");

                return jdbcTemplate.query(sqlSelect,new PeliculaExtractor(), titleLike, genreLike);

    }
}


class AirplaneExtractor implements ResultSetExtractor<List<Airplane>> {

    @Override
    public List<Airplane> extractData(ResultSet rs) throws SQLException, DataAccessException {
        // este metodo es implementado
        Map<Integer,Airplane> map = new HashMap<>();
        Airplane airplane = null;

        while(rs.next()){ //le pregunta al ResultSet si tiene registros por recorrer
           int peliculaId = rs.getInt("airplane_id");
           airplane = map.get(airplaneId);

           if (airplane == null) {
            airplane = new Airplane();
            airplane.setAirlineId(airplaneId);
            airplane.setTitulo(rs.getString("titulo"));
            
            //pasar este a Airline
            Airline airline = new Airline();
            airline.setGeneroId(rs.getInt("genero_id"));
            airline.setNombreGenero(rs.getString("nombre_genero"));
            
            //pasar este a AirplaneType
            AirplaneType genero = new AirplaneType();
            genero.setGeneroId(rs.getInt("genero_id"));
            genero.setNombreGenero(rs.getString("nombre_genero"));
            
            pelicula.setGenero(genero);
            pelicula.setSubtitulada(rs.getBoolean("subtitulada"));
            pelicula.setEstreno(rs.getBoolean("estreno"));
            map.put(peliculaId,pelicula);

           } //if
           int actorId = rs.getInt("actor_id");
           
           if(actorId > 0){
            Actor actor = new Actor();
            actor.setActorId(actorId);
            actor.setNombreActor(rs.getString("nombre_actor"));
            actor.setApellidosActor(rs.getString("apellidos_actor"));
            
            pelicula.getActores().add(actor);//ojo
           }
        }//while
        return new ArrayList<Pelicula>(map.values());
    }
    
}