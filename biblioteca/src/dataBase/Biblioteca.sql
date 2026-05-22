create table autor(
id serial primary key,
nome varchar(100) not null,
nacionalidade varchar(50) not null,
dataNascimento date not null);

create table livro(
id serial primary key,
titulo varchar(200) not null,
isbn varchar(13) not null,
anoPublicacao int not null,
genero varchar(30) not null,
id_autor int,
foreign key (id_autor) references autor(id));




