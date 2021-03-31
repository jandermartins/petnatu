package br.crateus.kariri.petnat.sessão;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Sessao {
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    String emailUsuario, idUsuario;

    private static Sessao sessao = new Sessao();

    public Sessao(){
        mAuth = FirebaseAuth.getInstance();

        if (mAuth != null){
            mUser = mAuth.getCurrentUser();
        }
        if (mUser != null){
            idUsuario = mUser.getUid();
            emailUsuario = mUser.getEmail();
        }
    }

    public FirebaseAuth getAutenticacaoUsuario(){

        mAuth = FirebaseAuth.getInstance();

        return mAuth;
    }

    public FirebaseUser getAuthUser(){
        mAuth = FirebaseAuth.getInstance();

        if(mAuth != null){
            return mAuth.getCurrentUser();
        }
        return null;
    }

    public String getIdUsuario(){
        mAuth = FirebaseAuth.getInstance();

        if(mAuth != null){
            mUser = mAuth.getCurrentUser();

            if(mUser != null){
                return mUser.getUid();
            }
        }
        return null;
    }

    public String getEmailUsuario(){
        mAuth = FirebaseAuth.getInstance();

        if(mAuth != null){
            mUser = mAuth.getCurrentUser();
            if(mUser != null){
                return mUser.getEmail();
            }
        }
        return null;
    }

    public static Sessao getInstance(){
        if(sessao == null){
            return new Sessao();
        }
        return sessao;
    }

    public static void sair(){
        sessao.getAutenticacaoUsuario().signOut();
    }
}
