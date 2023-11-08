package me.mattco.serenityos.idl.project

import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.jetbrains.cidr.lang.psi.OCDeclaration
import com.jetbrains.cidr.lang.psi.OCStructLike
import me.mattco.serenityos.idl.IDLFile
import me.mattco.serenityos.idl.psi.IDLDeclaration
import java.nio.file.Path

interface IDLProjectService {
    fun resolveImportedFile(from: VirtualFile, path: Path): IDLFile?

    fun findIDLDeclarations(directory: VirtualFile, name: String): Set<IDLDeclaration>

    fun findCppDeclarations(directory: VirtualFile, name: String): Set<OCStructLike>
}

val Project.idlProject: IDLProjectService
    get() = service()

val PsiElement.idlProject: IDLProjectService
    get() = project.idlProject
