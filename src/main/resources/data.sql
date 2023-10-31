INSERT INTO categoria(id, nome) 
VALUES
  (1, 'Lanche') 
  ON CONFLICT DO NOTHING;
  
INSERT INTO categoria(id, nome) 
VALUES
    (2, 'Acompanhamento')
  ON CONFLICT DO NOTHING;
    
INSERT INTO categoria(id, nome) 
VALUES
    (3, 'Bebida')
  ON CONFLICT DO NOTHING;
    
INSERT INTO categoria(id, nome) 
VALUES
    (4, 'Sobremesa')
  ON CONFLICT DO NOTHING;
