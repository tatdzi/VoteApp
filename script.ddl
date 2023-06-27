create sequence if not exists app.artists_id_seq;

alter sequence app.artists_id_seq owner to postgres;

create sequence if not exists app.genre_id_seq;

alter sequence app.genre_id_seq owner to postgres;

create table if not exists app.artists
(
    artists_id bigint default nextval('app.artists_id_seq'::regclass) not null
        primary key,
    name       text                                                   not null
);
alter table app.artists
    owner to postgres;
alter sequence app.artists_id_seq owned by app.artists.artists_id;

create table if not exists app.genre
(
    genre_id bigint default nextval('app.genre_id_seq'::regclass) not null
        primary key,
    name     text                                                 not null
);

alter table app.genre
    owner to postgres;

alter sequence app.genre_id_seq owned by app.genre.genre_id;

create table if not exists app.votes
(
    votes_id bigserial
        primary key,
    info     text,
    date     date
);

alter table app.votes
    owner to postgres;

create table if not exists app.votes_artists
(
    votes_id   bigserial
        references app.votes
            on update cascade on delete cascade,
    artists_id bigserial
        references app.artists
);

alter table app.votes_artists
    owner to postgres;

create table if not exists app.votes_genre
(
    votes_id bigserial
        references app.votes
            on update cascade on delete cascade,
    genre_id bigserial
        references app.genre
);

alter table app.votes_genre
    owner to postgres;


