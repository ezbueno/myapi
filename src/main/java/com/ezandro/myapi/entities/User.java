package com.ezandro.myapi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements Serializable {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo NOME é obrigatório!")
	@Length(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
	private String nome;
	
	@NotEmpty(message = "Campo LOGIN é obrigatório!")
	@Length(min = 3, max = 20, message = "O login deve ter entre 3 e 20 caracteres.")
	private String login;
	
	@NotEmpty(message = "Campo SENHA é obrigatório!")
	@Length(min = 3, max = 15, message = "A senha deve ter entre 3 e 15 caracteres.")
	private String senha;
	
}
