create table if not exists user_info (
    id serial not null constraint user_info_pk primary key,
    email varchar(60),
    name varchar(50)
);

create table if not exists distro (
    id serial not null constraint distro_pk primary key,
    name varchar(50),
    based_on varchar
);

create table if not exists device (
    id serial not null constraint roadmap_pk primary key,
    type varchar(8),
    brand varchar(20),
    model varchar(30),
    processor varchar(50),
    ram_memory varchar(20),
    disk varchar(20),
    card_video varchar(50),
    user_info_id integer constraint device_user_info_fk references user_info
);

create table if not exists test (
    id uuid not null constraint test_pk primary key,
    kind varchar,
    date date,
    distro_id integer constraint test_distro_fk references distro,
    distro_version varchar(30),
    kernel varchar(50),
    desktop_environment varchar(30),
    device_id int8 constraint test_device_fk references device
);

create table if not exists events (
    date_time timestamp without time zone not null constraint events_id primary key,
    kind varchar(20) not null,
    is_done boolean default false,
    payload text
);

CREATE INDEX idx_events_is_done ON events (is_done);
CREATE INDEX idx_events_date_time_is_done ON events (date_time, is_done);
-- CREATE INDEX idx_events_kind_is_done ON events (kind, is_done);

