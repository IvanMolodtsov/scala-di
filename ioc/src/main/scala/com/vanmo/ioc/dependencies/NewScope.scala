package com.vanmo.ioc.dependencies

import com.vanmo.common.IDependency
import com.vanmo.ioc.scopes.{IScope, Scope}
import com.vanmo.ioc.{CURRENT_SCOPE, resolve}

object NewScope extends IDependency[Option[IScope], IScope] {
  override def apply(parent: Option[IScope]): IScope =
    parent match {
      case Some(s) => Scope(s)
      case None => Scope(resolve(CURRENT_SCOPE))
    }
}
