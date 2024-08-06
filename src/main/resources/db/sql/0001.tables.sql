CREATE TABLE equipment_type (
                                    id uuid PRIMARY KEY,
                                    type_name text
);

CREATE TABLE equipment (
    id uuid primary key,
    type_id uuid,
    developer_name text,
    price numeric,
    added_at timestamp,
    CONSTRAINT fk_equipment_type foreign key (type_id) references equipment_type(id) on delete set null on update cascade
);

CREATE TABLE specification (
    id uuid PRIMARY KEY,
    type_id uuid,
    specification_name text,
    CONSTRAINT fk_spec_type foreign key (type_id) references equipment_type(id) on delete cascade on update cascade
);

CREATE TABLE equipment_spec (
    id uuid PRIMARY KEY,
    spec_id uuid,
    equip_id uuid,
    value text,
    UNIQUE (spec_id, equip_id),
    CONSTRAINT fk_spec_equip foreign key (equip_id) references equipment(id) on delete cascade on update cascade,
    CONSTRAINT fk_equip_spec foreign key (spec_id) references specification(id) on delete cascade on update cascade
);