INSERT INTO public.users(user_id, apellido, email, enabled, encryted_password, nombre, user_name)
    VALUES (1, 'Sistema', 'admin@admin.com', TRUE ,'$2a$10$J957l9hBHGK6qntclfImROIPnA51GVIakXBeuYco0pwIUjAEoqTSu', 'Administrador', 'admin');

INSERT INTO public.roles(role_id, role)
    VALUES (1, 'ADMIN');

INSERT INTO public.user_role(user_id, role_id)
    VALUES (1, 1);