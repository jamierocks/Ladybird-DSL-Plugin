package me.mattco.serenityos.idl.psi.mixins

import com.intellij.lang.ASTNode
import com.intellij.psi.util.parentOfType
import me.mattco.serenityos.idl.IDLFile
import me.mattco.serenityos.idl.IDLResolver
import me.mattco.serenityos.idl.psi.IDLNamedElement
import me.mattco.serenityos.idl.psi.api.IDLExtendedAttribute
import me.mattco.serenityos.idl.psi.api.IDLExtendedAttributeIdent
import me.mattco.serenityos.idl.psi.api.IDLIdent
import me.mattco.serenityos.idl.psi.singleRef

abstract class IDLIdentMixin(node: ASTNode) : IDLNamedElement(node), IDLIdent {
    override fun getReference() = singleRef {
        IDLResolver(containingFile as IDLFile).resolveIdent(this)
    }
}
