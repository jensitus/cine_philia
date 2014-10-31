package at.cinephilia.model;

import at.cinephilia.config.app.AppConf;
import at.cinephilia.web.movie.dao.MovieDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConf.class})
@Transactional
public class DaoTest {

    @Autowired
    private MovieDao movieDao;

    @Test
    public void testSaveAndLoad(){
        Movie movie = new Movie();
        movie.setTitle("Der Test");
        //movie.setRuntime((short) 7);
        movieDao.addMovie(movie);
        Assert.assertNotNull(movie.getId());
        Movie movie2 = movieDao.loadMovieById(movie.getId());
        Assert.assertEquals(movie, movie2);

    }


    @Test
    public void testMovieWithSchedules(){
        Theater theater = new Theater();
        //...set props

        //theaterDao.save
        Movie movie = new Movie();
        movie.setTitle("Der Test");
        //movie.setRuntime((short) 7);
        Schedule schedule = new Schedule();//set IDs
        movieDao.addMovie(movie);
        Assert.assertNotNull(movie.getId());
        Movie movie2 = movieDao.loadMovieById(movie.getId());
        Assert.assertEquals(movie, movie2);

    }

}
