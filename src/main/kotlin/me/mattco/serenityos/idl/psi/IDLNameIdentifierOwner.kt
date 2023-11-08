package me.mattco.serenityos.idl.psi

import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiNameIdentifierOwner

interface IDLNameIdentifierOwner : IDLPsiElement, PsiNameIdentifierOwner, NavigatablePsiElement
