CREATE TABLE IF NOT EXISTS tasks
(
    id                      varchar not null
        primary key,
    number                  integer,
    state                   varchar(255),
    answer                  integer,
    local_date_time_created timestamp,
    local_date_time_done    timestamp
);

