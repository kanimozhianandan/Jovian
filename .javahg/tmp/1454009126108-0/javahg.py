###
# #%L
# JavaHg
# %%
# Copyright (C) 2012 aragost Trifork ag
# %%
# Permission is hereby granted, free of charge, to any person obtaining a copy
# of this software and associated documentation files (the "Software"), to deal
# in the Software without restriction, including without limitation the rights
# to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
# copies of the Software, and to permit persons to whom the Software is
# furnished to do so, subject to the following conditions:
# 
# The above copyright notice and this permission notice shall be included in
# all copies or substantial portions of the Software.
# 
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
# THE SOFTWARE.
# #L%
###

# Helper functions for JavaHg.
#
# Copyright 2012 aragost Trifork

from mercurial.i18n import _
from mercurial import util, commands, cmdutil, lock, extensions

"""Helper functions for JavaHg"""

cmdtable = {}
command = cmdutil.command(cmdtable)

LOCK = None

@command('javahg-lock', [])
def takelock(ui, repo):
    """lock the repository"""
    global LOCK
    LOCK = repo.lock()

@command('javahg-unlock', [])
def releaselock(ui, repo):
    """unlock the repository"""
    global LOCK
    if LOCK is not None:
        LOCK.release()
        LOCK = None

def cmdutilcommit(orig, ui, repo, ignored_commitfunc, pats, opts):
    return orig(ui, repo, commitfunc, pats, opts)

def commitfunc(ui, repo, message, match, opts):
    # the following duplicates the start of commands.commit:
    extra = {}
    if opts.get('close_branch'):
        # normal commit will have checked that --close-branch is valid
        extra['close'] = 1
    e = cmdutil.commiteditor
    if opts.get('force_editor'):
        e = cmdutil.commitforceeditor

    # add more extra entries:
    for flag in opts.get('javahg_extra', []):
        try:
            key, value = flag.split('=', 1)
            extra[key] = value
        except ValueError:
            raise util.Abort(_('could not parse %r as key=value format') % e)

    # make commit like the original commitfunc from mercurial.commands
    # would have done it:
    return repo.commit(message, opts.get('user'), opts.get('date'), match,
                       editor=e, extra=extra)

def extsetup(ui):
    aliases, entry = cmdutil.findcmd('commit', commands.table)
    entry[1].append(('', 'javahg-extra', [],
                     _("add extra meta data (use 'key=value')")))
    extensions.wrapfunction(cmdutil, 'commit', cmdutilcommit)
