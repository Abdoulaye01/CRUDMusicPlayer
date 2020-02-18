package com.example.music;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.oxm.xstream.XStreamMarshaller;
import com.example.model.Playlist;


@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
 
 @Autowired
 public JobBuilderFactory jobBuilderFactory;
 
 @Autowired
 public StepBuilderFactory stepBuilderFactory;
 
 @Autowired
 public DataSource dataSource;
 
 @Bean
 public DataSource dataSource() {
  final DriverManagerDataSource dataSource = new DriverManagerDataSource();
  dataSource.setDriverClassName("com.mysql.jdbc.Driver");
  dataSource.setUrl("jdbc:mysql://localhost:3306/Music");
  dataSource.setUsername("root");
  dataSource.setPassword("mysql1020");
  
  return dataSource;
 }
 
 @Bean
 public StaxEventItemReader<Playlist>reader(){
  StaxEventItemReader<Playlist> reader = new StaxEventItemReader<Playlist>();
  reader.setResource(new ClassPathResource("playlist.xml"));
  reader.setFragmentRootElementName("dict");
  
  
  Map<String, String> aliases = new HashMap<String, String>();
  aliases.put("dict", "com.example.model.Playlist");
  
  XStreamMarshaller xStreamMarshaller = new XStreamMarshaller();
  xStreamMarshaller.setAliases(aliases);
  
  reader.setUnmarshaller(xStreamMarshaller);
  
  return reader;
 }
 
 @Bean
 public JdbcBatchItemWriter<Playlist>writer(){
  JdbcBatchItemWriter<Playlist>writer = new JdbcBatchItemWriter<Playlist>();
  writer.setDataSource(dataSource);
  writer.setSql("insert into playlist(listid,name,artist,album,genre,year) values(?,?,?,?,?,?)");
  writer.setItemPreparedStatementSetter(new UserItemPreparedStmSetter());
  
  return writer;
 }
 
 private class UserItemPreparedStmSetter implements ItemPreparedStatementSetter<Playlist>{

  @Override
  public void setValues(Playlist play, PreparedStatement ps) throws SQLException {

   ps.setInt(1, play.getTrackId());
   ps.setString(2, play.getArtist());
   ps.setString(3, play.getName());
   ps.setString(4, play.getAlbum());
   ps.setString(5, play.getGenre());
   ps.setInt(6, play.getYear());
   
  }
  
 }
 
 @Bean
 public Step step1() {
  return stepBuilderFactory.get("step1")
    .<Playlist, Playlist> chunk(10)
    .reader(reader())
    .writer(writer())
    .build();
 }
 
 @Bean
 public Job importUserJob() {
  return jobBuilderFactory.get("importUserJob")
    .incrementer(new RunIdIncrementer())
    .flow(step1())
    .end()
    .build();
    
 }
}